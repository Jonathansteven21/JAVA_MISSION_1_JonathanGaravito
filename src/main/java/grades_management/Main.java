package grades_management;

import grades_management.services.ClassroomService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String simpleLine = "-------------------------------------------";
        String doubleLine = "===============================";

        int studentsNumber = askForStudentsNumber();

        // Create a ClassroomService to manage the class and students
        ClassroomService classroomService = new ClassroomService();
        classroomService.createClassroom(studentsNumber);

        // Input and print scores for each student
        for (int i = 0; i < studentsNumber; i++) {
            String name = String.format("STD%s", formatNumber(i + 1));
            inputStudentScores(name, i, classroomService);
            System.out.println(simpleLine);
            classroomService.printStudentInfo(i);
            System.out.println(simpleLine);
            classroomService.sortList();
            classroomService.printCurrentRankStudent(name);
            System.out.println(simpleLine);
        }

        // Print the list of students and their average scores
        classroomService.printStudentList();
        System.out.println(doubleLine);

        // Calculate and print the average scores for each subject in the class
        classroomService.calculateSubjectAvg();
        classroomService.printSubjectList();
        System.out.println(doubleLine);
    }

    /**
     * Asks the user for the number of students in the class.
     *
     * @return The number of students in the class.
     */
    public static int askForStudentsNumber() {
        boolean validInput = false;
        int studentsNumber = 0;

        do {
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
        } while (!validInput);

        return studentsNumber;
    }

    /**
     * Input scores for a student and add the student to the class.
     *
     * @param studentIndex     The index of the student.
     * @param classroomService The ClassroomService to manage the class.
     */
    public static void inputStudentScores(String name, int studentIndex, ClassroomService classroomService) {
        // Generate a student name and input scores for each subject
        int javaScore = askForScore(name, "Java");
        int sqlScore = askForScore(name, "SQL");
        int mathScore = askForScore(name, "Math.");
        int englishScore = askForScore(name, "English");

        // Add the student to the class
        classroomService.addStudent(studentIndex, name, javaScore, sqlScore, mathScore, englishScore);
    }


    /**
     * Asks the user for a score for a specific subject.
     *
     * @param studentName The name of the student.
     * @param subject     The subject for which to input the score.
     * @return The entered score.
     */
    private static int askForScore(String studentName, String subject) {
        int score = 0;
        boolean validInput = false;

        do {
            try {
                System.out.printf("%s Student's %s Score : ", studentName, subject);
                score = scanner.nextInt();

                if (score < 0) {
                    throw new IllegalArgumentException("The score must be at least 0");
                }
                if (score > 100) {
                    throw new IllegalArgumentException("The score must not be greater than 100");
                }

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input: Please enter a valid score for the subject");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input: " + e.getMessage());
            }
        } while (!validInput);
        return score;
    }

    /**
     * Formats a number to include leading zeros if less than or equal to 9.
     *
     * @param number The number to format.
     * @return The formatted number.
     */
    public static String formatNumber(int number) {
        if (number <= 9) {
            return String.format("0%s", number);
        } else {
            return Integer.toString(number);
        }
    }
}
