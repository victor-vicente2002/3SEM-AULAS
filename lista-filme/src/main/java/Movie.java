public class Movie {
    private Integer idMovie;
    private String name;
    private Double grade;
    private String genre;
    private Integer age;

    public Movie(Integer idMovie, String name, Double grade, String genre, Integer age) {
        this.idMovie = idMovie;
        this.name = name;
        this.grade = grade;
        this.genre = genre;
        this.age = age;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "idMovie=" + idMovie +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", genre='" + genre + '\'' +
                ", age=" + age +
                '}';
    }
}
