import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;


class DatabaseQuestionManager extends QuestionManager {
    private Connection connection;

    public DatabaseQuestionManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void initializeDatabase() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS questions (" +
                "id SERIAL PRIMARY KEY, " +
                "question TEXT, " +
                "answer TEXT)";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error initializing the database", e);
        }
    }

    @Override
    public void addQuestion(AbstractQuestion question) {
        String insertSQL = "INSERT INTO questions (question, answer) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, question.getQuestion());
            statement.setString(2, question.getAnswer());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding question to the database", e);
        }
    }

    @Override
    public List<AbstractQuestion> getAllQuestions() {
        String selectSQL = "SELECT * FROM questions";
        List<AbstractQuestion> questions = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(selectSQL);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String question = resultSet.getString("question");
                String answer = resultSet.getString("answer");
                questions.add(new Question(id, question, answer)); // Предполагается, что Question - это класс, который наследуется от AbstractQuestion.
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all questions from the database", e);
        }
        return questions;
    }

    // Дополнительные методы, такие как searchQuestion, можно реализовать аналогично.
}