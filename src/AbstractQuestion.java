import java.sql.Connection;
import java.util.Objects;


public abstract class AbstractQuestion {
    private String text;
    private String answer;

    // Конструктор
    protected AbstractQuestion(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public AbstractQuestion(int i) {
    }

    // Геттеры и сеттеры
    public String getText() {
        return text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String newAnswer) {
        this.answer = newAnswer;
    }

    // Абстрактный метод для проверки ответа
    public abstract boolean checkAnswer(String candidateAnswer);

    // Переопределение toString()
    @Override
    public String toString() {
        return "Question: " + text + ", Answer: " + answer;
    }

    // Переопределение equals() для сравнения объектов
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AbstractQuestion that = (AbstractQuestion) obj;
        return text.equals(that.text) && answer.equals(that.answer);
    }
    private Connection connection;

    // Переопределение hashCode() для корректной работы в коллекциях
    @Override
    public int hashCode() {
        return Objects.hash(text, answer);
    }

    public abstract String getQuestion();
}