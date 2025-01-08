import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseExample {

    private static final String URL = "jdbc:postgresql://localhost:5432/exam_db";
    private static final String USER = "root";
    private static final String PASSWORD = "aiym125140";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void saveQuestion(Question question) throws SQLException {
        String sql = "INSERT INTO questions (question, answer) VALUES (?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, question.getText());
            stmt.setString(2, question.getAnswer());
            stmt.executeUpdate();
        }
    }

    public static List<Question> getAllQuestions() throws SQLException {
        String sql = "SELECT * FROM questions";
        List<Question> questions = new ArrayList<>();
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                questions.add(new Question(rs.getString("question"), rs.getString("answer")));
            }
        }
        return questions;
    }

    public static void updateQuestion(Question question) throws SQLException {
        String sql = "UPDATE questions SET answer = ? WHERE question = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, question.getAnswer());
            stmt.setString(2, question.getText());
            stmt.executeUpdate();
        }
    }

    public static void deleteQuestion(String questionText) throws SQLException {
        String sql = "DELETE FROM questions WHERE question = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, questionText);
            stmt.executeUpdate();
        }
    }
}
