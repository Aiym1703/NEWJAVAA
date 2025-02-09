import java.util.Scanner;
class OnlineExamSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String candidateName = scanner.nextLine();
        Candidate candidate = new Candidate(1,candidateName);

        Question[] questions = {
                new Question("1 byte equals to?", "8 bits"),
                new Question("What is OOP?", "Object-Oriented Programming"),
                new Question("Capital of Kazakhstan?", "Astana"),
                new Question("5*5 equals to?", "25"),
                new Question("5*6 equals to?", "30")
        };


        Exam exam = new Exam("General Knowledge",candidate, questions);
        System.out.print("Enter a keyword to filter questions: ");
        String keyword = scanner.nextLine();
        exam.filterQuestions(keyword);
        System.out.println("Sorting questions...");
        exam.sortQuestions();
        exam.start();
    }
}
