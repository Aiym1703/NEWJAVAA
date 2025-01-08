import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public abstract class QuestionManager {

    private List<AbstractQuestion> questions; // Список для хранения вопросов

    // Конструктор
    public QuestionManager() {
        this.questions = new ArrayList<>();
    }

    public abstract void initializeDatabase();

    // Добавление вопроса
    public void addQuestion(AbstractQuestion question) {
        questions.add(question);
    }

    // Вывод всех вопросов
    public void displayAllQuestions() {
        for (AbstractQuestion question : questions) {
            System.out.println(question);
        }
    }

    // Поиск вопроса по тексту (игнорируя регистр)
    public AbstractQuestion searchQuestion(String text) {
        return questions.stream()
                .filter(q -> q.getText().equalsIgnoreCase(text))
                .findFirst()
                .orElse(null);
    }

    // Фильтрация вопросов по ключевому слову
    public List<AbstractQuestion> filterQuestions(String keyword) {
        return questions.stream()
                .filter(q -> q.getText().contains(keyword))
                .collect(Collectors.toList());
    }

    // Сортировка вопросов по тексту
    public void sortQuestions() {
        questions.sort(Comparator.comparing(AbstractQuestion::getText));
    }

    public abstract List<AbstractQuestion> getAllQuestions();
}