package grades_management.services;

import grades_management.entities.Student;

/**
 * Service class for managing operations related to students.
 */
public class StudentService {

    /**
     * Creates a new student with provided details and calculates the average score.
     *
     * @param name         The name of the student.
     * @param javaScore    The Java score of the student.
     * @param sqlScore     The SQL score of the student.
     * @param mathScore    The Math score of the student.
     * @param englishScore The English score of the student.
     * @return The newly created student.
     */
    public Student createStudent(String name, Integer javaScore, Integer sqlScore, Integer mathScore, Integer englishScore) {
        Student student = new Student();
        student.setName(name);
        student.setJavaScore(javaScore);
        student.setSqlScore(sqlScore);
        student.setMathScore(mathScore);
        student.setEnglishScore(englishScore);

        // Calculate average score
        int sum = student.getJavaScore() + student.getSqlScore() + student.getMathScore() + student.getEnglishScore();
        Float averageScore = (float) sum / 4;
        student.setAverageScore(averageScore);

        return student;
    }

    /**
     * Retrieves information about a student's scores.
     *
     * @param student The student for whom to retrieve information.
     * @return A formatted string with the student's score status.
     */
    public String getStudentInfo(Student student) {
        return String.format("[%s] Student's Score Status%nJava %s, SQL %s, Math. %s, English %s", student.getName(), student.getJavaScore(), student.getSqlScore(), student.getMathScore(), student.getEnglishScore());
    }

    /**
     * Retrieves the average score of a student.
     *
     * @param student The student for whom to retrieve the average score.
     * @return A formatted string with the student's average score.
     */
    public String getStudentAvg(Student student) {
        return String.format("Avg.:%.2f", student.getAverageScore());
    }
}
