public class Student {

    private String name;
    private String ra;
    private String course;
    private String subject;
    private int faults;
    private Double grade;

    public Student(String name, String ra, String course, String subject, int faults, Double grade) {
        this.name = name;
        this.ra = ra;
        this.course = course;
        this.subject = subject;
        this.faults = faults;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ra='" + ra + '\'' +
                ", course='" + course + '\'' +
                ", subject='" + subject + '\'' +
                ", faults=" + faults +
                ", grade=" + grade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getFaults() {
        return faults;
    }

    public void setFaults(int faults) {
        this.faults = faults;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
