package question03tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import question03.Person;
import question03.PersonMyUtils;
import question03.Student;
import question03.Worker;

import java.util.ArrayList;
import java.util.List;

public class Task03Tests {
    @Test
    public void testMaxDuration(){
        PersonMyUtils myUtils = new PersonMyUtils();
        List<Person> originList = new ArrayList();
        originList.add(new Person("Ivan"));
        originList.add(new Student("Petro", "University", 3));
        originList.add(new Worker("Andriy", "Developer", 12));
        originList.add(new Student("Stepan", "College", 4));
        originList.add(new Worker("Ira", "Manager", 8));
        originList.add(new Student("Ihor", "University", 1));
        List<Person> expected = new ArrayList();
        expected.add(new Worker("Andriy", "Developer", 12));
        expected.add(new Student("Stepan", "College", 4));
        List<Person> persons = myUtils.maxDuration1(originList);
        for (Person person: persons) {
            if (person instanceof Student){
                System.out.println(person.getName() + " : " + ((Student)person).getStudyPlace() + " : " + ((Student)person).getStudyYears());
            } else{
                System.out.println(person.getName() + " : " + ((Worker)person).getWorkPosition() + " : " + ((Worker)person).getExperienceYears());
            }

        }
    }
}
