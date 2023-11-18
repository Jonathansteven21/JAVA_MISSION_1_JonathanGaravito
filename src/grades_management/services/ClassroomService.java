package grades_management.services;

import grades_management.entities.Classroom;
import grades_management.entities.Student;

import java.util.Arrays;

/**
 * Service class for managing operations related to classrooms and students.
 */
public class ClassroomService {

    private final Classroom classroom;
    private final StudentService studentService;

    /**
     * Default constructor for the ClassroomService class.
     * Initializes a new Classroom and a StudentService.
     */
    public ClassroomService() {
        classroom = new Classroom();
        studentService = new StudentService();
    }

    /**
     * Creates a classroom with a specified number of students, initializing their average scores.
     *
     * @param studentsNumber The number of students in the classroom.
     */
    public void createClassroom(Integer studentsNumber) {
        Student[] studentsList = new Student[studentsNumber];
        Student student = new Student();
        student.setAverageScore(0f);
        Arrays.fill(studentsList, student);
        classroom.setStudentsList(studentsList);
    }

    /**
     * Adds a new student to the classroom at a specified index.
     *
     * @param studentIndex  The index where the student will be added.
     * @param name          The name of the student.
     * @param javaScore     The Java score of the student.
     * @param sqlScore      The SQL score of the student.
     * @param mathScore     The Math score of the student.
     * @param englishScore  The English score of the student.
     */
    public void addStudent(int studentIndex, String name, Integer javaScore, Integer sqlScore, Integer mathScore, Integer englishScore) {
        Student student = studentService.createStudent(name, javaScore, sqlScore, mathScore, englishScore);
        classroom.getStudentsList()[studentIndex] = student;
    }

    /**
     * Prints information about a specific student.
     *
     * @param studentIndex The index of the student to print.
     */
    public void printStudentInfo(int studentIndex) {
        System.out.println(studentService.getStudentInfo(classroom.getStudentsList()[studentIndex]));
    }

    /**
     * Sorts the list of students based on their average scores in descending order.
     */
    public void sortList() {
        Student[] studentsList = classroom.getStudentsList();
        Arrays.sort(studentsList);
    }

    /**
     * Gets the current rank of a student based on their average score.
     *
     * @param name The name of the student.
     * @return The rank of the student.
     */
    public int getCurrentRankStudent(String name) {
        for (int i = 0; i < classroom.getStudentsList().length; i++) {
            if (classroom.getStudentsList()[i].getName().equals(name)) {
                return i + 1;
            }
        }
        return 0;
    }

    /**
     * Prints the current rank and average score of a student.
     *
     * @param name The name of the student.
     */
    public void printCurrentRankStudent(String name) {
        int rank = getCurrentRankStudent(name);
        String averageScore = studentService.getStudentAvg(classroom.getStudentsList()[rank - 1]);
        System.out.printf("%s,Rank:%s%n", averageScore, rank);
    }

    /**
     * Prints a list of students with their names, average scores, and ranks.
     */
    public void printStudentList() {
        for (int i = 0; i < classroom.getStudentsList().length; i++) {
            String name = classroom.getStudentsList()[i].getName();
            String averageScore = studentService.getStudentAvg(classroom.getStudentsList()[i]);
            int rank = i + 1;
            System.out.printf("%s:=>%s,Rank:%s%n", name, averageScore, rank);
        }
    }

    /**
     * Calculates and sets the average scores for each subject in the classroom.
     */
    public void calculateSubjectAvg() {
        int sumJava = 0, sumSql = 0, sumMath = 0, sumEnglish = 0;
        for (Student student : classroom.getStudentsList()) {
            sumJava += student.getJavaScore();
            sumSql += student.getSqlScore();
            sumMath += student.getMathScore();
            sumEnglish += student.getEnglishScore();
        }

        Float javaAvgScore = (float) sumJava / classroom.getStudentsList().length;
        classroom.setJavaAvgScore(javaAvgScore);
        Float sqlAvgScore = (float) sumSql / classroom.getStudentsList().length;
        classroom.setSqlAvgScore(sqlAvgScore);
        Float mathAvgScore = (float) sumMath / classroom.getStudentsList().length;
        classroom.setMathAvgScore(mathAvgScore);
        Float englishAvgScore = (float) sumEnglish / classroom.getStudentsList().length;
        classroom.setEnglishAvgScore(englishAvgScore);
    }

    /**
     * Prints the average scores for each subject in the classroom.
     */
    public void printSubjectList() {
        System.out.printf("Java Class Avg.:%.2f%n", classroom.getJavaAvgScore());
        System.out.printf("SQL Class Avg.:%.2f%n", classroom.getSqlAvgScore());
        System.out.printf("Math. Class Avg.:%.2f%n", classroom.getMathAvgScore());
        System.out.printf("English Class Avg.:%.2f%n", classroom.getEnglishAvgScore());
    }
}
