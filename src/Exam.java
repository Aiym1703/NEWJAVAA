import java.util.Scanner;

public class Exam {
    private String title; // Заголовок экзамена
    private Candidate candidate;
    private Question[] questions;
    private int score;

    public Exam(String title, Candidate candidate, Question[] questions) {
        this.title = title;
        this.candidate = candidate;
        this.questions = questions;
        this.score = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + candidate.getName() + "! Let's start the exam.");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i].getText());
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();
            if (userAnswer.equalsIgnoreCase(questions[i].getAnswer())) {
                score++;
            }
        }
        System.out.println("\nExam finished! You scored " + score + " out of " + questions.length);
    }
    public void filterQuestions(String keyword) {
        System.out.println("Filtered questions containing: " + keyword);
        for (Question question : questions) {
            if (question.getText().contains(keyword)) {
                System.out.println(question);
            }
        }
    }

    public void sortQuestions() {
        java.util.Arrays.sort(questions, (q1, q2) -> q1.getText().compareTo(q2.getText()));
        System.out.println("Questions sorted alphabetically.");
    }

    @Override
    public String toString() {
        return "Exam: " + title;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Exam exam = (Exam) obj;
        return title.equals(exam.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }
}


