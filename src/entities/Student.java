package entities;

public class Student implements Comparable<Student> {

    private String name;
    private Integer javaScore;
    private Integer sqlScore;
    private Integer mathScore;
    private Integer englishScore;
    private Float averageScore;


    public Student() {
        // Void Constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(Integer javaScore) {
        this.javaScore = javaScore;
    }

    public Integer getSqlScore() {
        return sqlScore;
    }

    public void setSqlScore(Integer sqlScore) {
        this.sqlScore = sqlScore;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public int compareTo(Student o) {
        return Float.compare(o.getAverageScore(), this.getAverageScore());
    }
}
