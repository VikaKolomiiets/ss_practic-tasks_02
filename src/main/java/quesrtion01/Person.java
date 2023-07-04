package quesrtion01;

public abstract class Person {

    private int age;
    private String healthInfo;
    private String name;

    public Person(int age, String healthInfo, String name) {
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getHealthInfo() {
        return healthInfo;
    }

    public String getName() {
        return name;
    }

    public String getHealthStatus() {
        return name + " " + healthInfo;
    }
}
