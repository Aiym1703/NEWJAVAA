public class Question extends AbstractQuestion {

    // Конструктор
    public Question(String text, String answer) {
        super(text, answer);
    }

    public Question(int id, String question, String answer) {
        super(2);
    }

    // Реализация метода проверки правильности ответа
    @Override
    public boolean checkAnswer(String candidateAnswer) {
        return getAnswer().equalsIgnoreCase(candidateAnswer);
    }

    // Переопределение toString() (уже в AbstractQuestion, но можем дополнить при необходимости)
    @Override
    public String toString() {
        return "Text Question: " + getText() + ", Answer: " + getAnswer();
    }

    @Override
    public String getQuestion() {
        return "";
    }
}