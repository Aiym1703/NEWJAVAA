import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String candidateName = scanner.nextLine();
        Candidate candidate = new Candidate(candidateName);

        Question[] questions = {
                new Question("1 byte equals to?", "8 bits"),
                new Question("What is OOP?", "Object-Oriented Programming"),
                new Question("Capital of Kazakhstan?", "Astana"),
                new Question("5*5 equals to?", "25")
        };

        Exam exam = new Exam(candidate, questions);
        exam.start();
    }
}
