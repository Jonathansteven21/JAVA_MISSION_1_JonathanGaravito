package services;

import entities.Student;

public class StudentService {


    public Student createStudent(String name, Integer javaScore, Integer sqlScore, Integer mathScore, Integer englishScore) {

        Student student = new Student();
        student.setName(name);
        student.setJavaScore(javaScore);
        student.setSqlScore(sqlScore);
        student.setMathScore(mathScore);
        student.setEnglishScore(englishScore);
        int sum = student.getJavaScore() + student.getSqlScore() + student.getMathScore() + student.getEnglishScore();
        Float averageScore = (float) sum / 4;
        student.setAverageScore(averageScore);

        return student;
    }

    public String getStudentInfo(Student student) {
        return String.format("[%s] Student's Score Status%nJava %s, SQL %s, Math. %s, English %s", student.getName(), student.getJavaScore(), student.getSqlScore(), student.getMathScore(), student.getEnglishScore());

    }

    public String getStudentAvg(Student student) {
        return String.format("Avg.:%.2f", student.getAverageScore());
    }

}
