package question03;

public class Worker extends Person {
    private String workPosition;
    private int experienceYears;

    public Worker(String name, String workPosition, int experienceYears) {
        super(name);
        this.setWorkPosition(workPosition);
        this.setExperienceYears(experienceYears);
    }

    public String getWorkPosition() {
        return workPosition;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setWorkPosition(String workPosition) {
        if (workPosition == null || workPosition.isEmpty()) {
            throw new NullPointerException("Please, check study Place input");
        }
        this.workPosition = workPosition;
    }

    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Years of study should be more than 0");
        }
        this.experienceYears = experienceYears;
    }
}
