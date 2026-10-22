package stream.colletors;

public class Student {
    private String name;
    private int grade;
    private int score;

    public Student(String name, int grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }
}
