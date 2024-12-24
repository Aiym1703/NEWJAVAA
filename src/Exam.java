import java.util.Scanner;

public class Exam {
    private Candidate candidate;
    private Question[] questions;
    private int score;

    public Exam(Candidate candidate, Question[] questions) {
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
}
