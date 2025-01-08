import java.util.List;

public class MultipleChoiceQuestion extends AbstractQuestion {
    private List<String> options;

    public MultipleChoiceQuestion(String text, String answer, List<String> options) {
        super(text, answer);
        this.options = options;
    }

    public List<String> getOptions() {
        return options;
    }

    @Override
    public boolean checkAnswer(String candidateAnswer) {
        return getAnswer().equalsIgnoreCase(candidateAnswer);
    }

    @Override
    public String toString() {
        return "Multiple Choice Question: " + getText() + "\nOptions: " + String.join(", ", options);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MultipleChoiceQuestion that = (MultipleChoiceQuestion) obj;
        return getText().equals(that.getText()) && getAnswer().equals(that.getAnswer()) && options.equals(that.options);
    }

    @Override
    public int hashCode() {
        return getText().hashCode() + getAnswer().hashCode() + options.hashCode();
    }

    @Override
    public String getQuestion() {
        return "";
    }
}
