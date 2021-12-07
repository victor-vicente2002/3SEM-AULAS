public class Student {

    private int ra;
    private String name;
    private Double grade;

    public Student(int ra, String name, Double grade) {
        this.ra = ra;
        this.name = name;
        this.grade = grade;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student: " +
                "name='" + name + '\'' +
                ", ra=" + ra +
                ", grade=" + grade;
    }
}
