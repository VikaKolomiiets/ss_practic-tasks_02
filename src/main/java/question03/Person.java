package question03;

import java.util.Objects;

public class Person {
    private String name;

    public Person(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Please, check study Place input");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return this.name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
