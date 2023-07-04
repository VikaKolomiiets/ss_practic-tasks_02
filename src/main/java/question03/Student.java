package question03;

public class Student extends Person {
    private String studyPlace;
    private int studyYears;

    public Student(String name) {
        super(name);
    }

    public Student(String name, String studyPlace, int studyYears) {
        super(name);
        this.setStudyPlace(studyPlace);
        this.setStudyYears(studyYears);
    }

    public String getStudyPlace() {
        return studyPlace;
    }

    public int getStudyYears() {
        return studyYears;
    }

    public void setStudyPlace(String studyPlace) {
        if (studyPlace == null || studyPlace.isEmpty()) {
            throw new NullPointerException("Please, check study Place input");
        }
        this.studyPlace = studyPlace;
    }

    public void setStudyYears(int studyYears) {
        if (studyYears < 0) {
            throw new IllegalArgumentException("Years of study should be more than 0");
        }
        this.studyYears = studyYears;
    }
}
