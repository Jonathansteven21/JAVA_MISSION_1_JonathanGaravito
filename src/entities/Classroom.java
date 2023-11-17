package entities;

public class Classroom {


    private Student[] studentsList;
    private Float javaAvgScore;
    private Float sqlAvgScore;
    private Float mathAvgScore;
    private Float englishAvgScore;

    public Classroom() {
        // Void Constructor
    }


    public Student[] getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(Student[] studentsList) {
        this.studentsList = studentsList;
    }

    public Float getJavaAvgScore() {
        return javaAvgScore;
    }

    public void setJavaAvgScore(Float javaAvgScore) {
        this.javaAvgScore = javaAvgScore;
    }

    public Float getSqlAvgScore() {
        return sqlAvgScore;
    }

    public void setSqlAvgScore(Float sqlAvgScore) {
        this.sqlAvgScore = sqlAvgScore;
    }

    public Float getMathAvgScore() {
        return mathAvgScore;
    }

    public void setMathAvgScore(Float mathAvgScore) {
        this.mathAvgScore = mathAvgScore;
    }

    public Float getEnglishAvgScore() {
        return englishAvgScore;
    }

    public void setEnglishAvgScore(Float englishAvgScore) {
        this.englishAvgScore = englishAvgScore;
    }

}
