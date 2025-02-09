class Question {
    private String text;
    private String answer;


    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public boolean checkAnswer(String candidateAnswer) {
        return answer.equalsIgnoreCase(candidateAnswer);
    }

    @Override
    public String toString() {
        return "Question: " + text;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Question question = (Question) obj;
        return text.equals(question.text) && answer.equals(question.answer);
    }

    @Override
    public int hashCode() {
        return text.hashCode() + answer.hashCode();
    }
}
