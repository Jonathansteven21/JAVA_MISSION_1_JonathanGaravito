package services;

import entities.Classroom;
import entities.Student;

import java.util.Arrays;

public class ClassroomService {

    private final Classroom classroom;
    private final StudentService studentService;

    public ClassroomService() {
        classroom = new Classroom();
        studentService = new StudentService();
    }

    public void createClassroom(Integer studentsNumber) {
        Student[] studentsList = new Student[studentsNumber];
        Student student = new Student();
        student.setAverageScore(0f);
        Arrays.fill(studentsList, student);
        classroom.setStudentsList(studentsList);
    }

    public void addStudent(int studentIndex, String name, Integer javaScore, Integer sqlScore, Integer mathScore, Integer englishScore) {
        Student student = studentService.createStudent(name, javaScore, sqlScore, mathScore, englishScore);
        classroom.getStudentsList()[studentIndex] = student;
    }

    public void printStudentInfo(int studentIndex) {
        System.out.println(studentService.getStudentInfo(classroom.getStudentsList()[studentIndex]));
    }

    public void sortList() {
        Student[] studentsList = classroom.getStudentsList();
        Arrays.sort(studentsList);
    }

    public void printCurrentRankStudent(String name) {
        int rank = getCurrentRankStudent(name);
        String averageScore = studentService.getStudentAvg(classroom.getStudentsList()[rank - 1]);
        System.out.printf("%s,Rank:%s%n", averageScore, rank);
    }

    public int getCurrentRankStudent(String name) {
        for (int i = 0; i < classroom.getStudentsList().length; i++) {
            if (classroom.getStudentsList()[i].getName().equals(name)) {
                return i + 1;
            }
        }
        return 0;
    }

    public void printStudentList() {
        for (int i = 0; i < classroom.getStudentsList().length; i++) {
            String name = classroom.getStudentsList()[i].getName();
            String averageScore = studentService.getStudentAvg(classroom.getStudentsList()[i]);
            int rank = i + 1;
            System.out.printf("%s:=>%s,Rank:%s%n", name, averageScore, rank);
        }
    }

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

    public void printSubjectList() {
        System.out.printf("Java Class Avg.:%.2f%n", classroom.getJavaAvgScore());
        System.out.printf("SQL Class Avg.:%.2f%n", classroom.getSqlAvgScore());
        System.out.printf("Math. Class Avg.:%.2f%n", classroom.getMathAvgScore());
        System.out.printf("English Class Avg.:%.2f%n", classroom.getEnglishAvgScore());
    }

}
