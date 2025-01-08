import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/your_database_name";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "aiym125140";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            QuestionManager manager = new DatabaseQuestionManager(connection);

            // Инициализируем базу данных
            ((DatabaseQuestionManager) manager).initializeDatabase();

            // Добавляем вопросы
            AbstractQuestion q1 = new Question("What is Java?", "A programming language");
            AbstractQuestion q2 = new Question("What is OOP?", "Object-Oriented Programming");
            AbstractQuestion q3 = new Question("Name a Java feature", "Platform Independence");

            manager.addQuestion(q1);
            manager.addQuestion(q2);
            manager.addQuestion(q3);

            // Вывод всех вопросов
            List<AbstractQuestion> allQuestions = ((DatabaseQuestionManager) manager).getAllQuestions();
            System.out.println("All questions:");
            allQuestions.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}