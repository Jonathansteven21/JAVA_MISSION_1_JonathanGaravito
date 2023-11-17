import services.ClassroomService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int studentsNumber = askForStudentsNumber();
        ClassroomService classroomService = new ClassroomService();
        classroomService.createClassroom(studentsNumber);

        for (int i = 0; i < studentsNumber; i++) {
            inputAndPrintStudentScores(i, classroomService);
        }
        classroomService.printStudentList();
        System.out.println("===============================");
        classroomService.calculateSubjectAvg();
        classroomService.printSubjectList();
        System.out.println("===============================");
    }

    public static int askForStudentsNumber() {
        boolean validInput = false;
        int studentsNumber = 0;
        while (!validInput) {
            try {
                System.out.print("How many students are in this class? : ");
                studentsNumber = scanner.nextInt();

                if (studentsNumber <= 0) {
                    throw new IllegalArgumentException("The number of students must be greater than 0");
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: Please enter a valid number of students.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        }
        return studentsNumber;
    }

    public static void inputAndPrintStudentScores(int studentIndex, ClassroomService classroomService) {
        String name = generateStudentName(studentIndex);
        int javaScore = askForScore(name, "Java");
        int sqlScore = askForScore(name, "SQL");
        int mathScore = askForScore(name, "Math.");
        int englishScore = askForScore(name, "English");

        classroomService.addStudent(studentIndex, name, javaScore, sqlScore, mathScore, englishScore);

        System.out.println("-------------------------------------------");
        classroomService.printStudentInfo(studentIndex);
        System.out.println("-------------------------------------------");
        classroomService.sortList();
        classroomService.printCurrentRankStudent(name);
        System.out.println("-------------------------------------------");
    }

    private static String generateStudentName(int index) {
        return String.format("STD%s", formatNumber(index + 1));
    }

    private static int askForScore(String studentName, String subject) {
        System.out.printf("%s Student's %s Score : ", studentName, subject);
        return scanner.nextInt();
    }

    public static String formatNumber(int number) {
        if (number <= 9) {
            return String.format("0%s", number);
        } else {
            return Integer.toString(number);
        }
    }
}
