package question03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonMyUtils {

//    public List<Person> maxDuration(List<Person> persons) {
//        List<Person> maxDurations = new ArrayList<>();
//        try{
//            Stream<Student> studentStream = persons.stream()
//                    .filter(Student.class::isInstance)
//                    .map(p -> (Student) p);
//            int maxStudyYear = studentStream.max((x, y) -> x.getStudyYears() - y.getStudyYears()).get().getStudyYears();
//            maxDurations.addAll(studentStream.filter(s -> s.getStudyYears() == maxStudyYear).collect(Collectors.toList()));
//            studentStream.close();
//        }catch (IllegalStateException e){
//            throw new IllegalStateException(e.getMessage());
//        }finally {
//
//        }
//
//        Stream<Worker> workerStream = persons.stream()
//                .filter(Worker.class::isInstance)
//                .map(p -> (Worker) p);
//        int maxWorkYear = workerStream.max((x, y) -> x.getExperienceYears() - y.getExperienceYears()).get().getExperienceYears();
//        maxDurations.addAll(workerStream.filter(w -> w.getExperienceYears() == maxWorkYear).collect(Collectors.toList()));
//        workerStream.close();
//
//        return maxDurations;
//    }

    public List<Person> maxDuration1(List<Person> persons) {
        if(persons == null){
            throw new NullPointerException("Collection is null");
        }

        List<Person> maxDurations = new ArrayList<>();

        int maxStudyYear = persons.stream()
                .distinct()
                .filter(Student.class::isInstance)
                .map(p11 -> (Student) p11).max((x, y) -> x.getStudyYears() - y.getStudyYears()).get().getStudyYears();
        maxDurations.addAll(persons.stream()
                .distinct()
                .filter(Student.class::isInstance)
                .map(p1 -> (Student) p1)
                .filter(s -> s.getStudyYears() == maxStudyYear)
                .toList());

        int maxWorkYear = persons.stream()
                .distinct()
                .filter(Worker.class::isInstance)
                .map(p -> (Worker) p).max((x, y) -> x.getExperienceYears() - y.getExperienceYears()).get().getExperienceYears();
        maxDurations.addAll(persons.stream()
                .distinct()
                .filter(Worker.class::isInstance)
                .map(p -> (Worker) p).filter(w -> w.getExperienceYears() == maxWorkYear)
                .toList());

        return maxDurations;
    }

    public List<Person> maxDuration2(List<Person> persons) {
        List<Person> maxDurations = new ArrayList<>();
        int maxStudyYear = 0;
        int maxWorkYear = 0;
        for (Person person : persons) {
            if (person instanceof Student) {
                if (((Student) person).getStudyYears() > maxStudyYear) {
                    maxStudyYear = ((Student) person).getStudyYears();
                }
            }
            if (person instanceof Worker) {
                if (((Worker) person).getExperienceYears() > maxWorkYear) {
                    maxWorkYear = ((Worker) person).getExperienceYears();
                }
            }
        }
        for (Person person : persons) {
            if (person instanceof Student) {
                if (((Student) person).getStudyYears() == maxStudyYear && !maxDurations.contains(person)) {
                    maxDurations.add(person);
                }
            }
            if (person instanceof Worker) {
                if (((Worker) person).getExperienceYears() == maxWorkYear && !maxDurations.contains(person)) {
                    maxDurations.add(person);
                }
            }
        }
        return maxDurations;
    }

//    public List<Person> maxDuration4(List<Person> persons) {
//        List<Person> maxDurations = new ArrayList<>();
//
//        int maxStudyYear = persons.stream()
//                .filter(Student.class::isInstance)
//                .map(p11 -> (Student) p11).max((x, y) -> x.getStudyYears() - y.getStudyYears()).get().getStudyYears();
//        maxDurations.addAll(persons.stream()
//                .filter(Student.class::isInstance)
//                .map(p1 -> (Student) p1).filter(s -> s.getStudyYears() == maxStudyYear).collect(Collectors.toList()));
//
//        int maxWorkYear = persons.stream()
//                .filter(Worker.class::isInstance)
//                .map(p -> (Worker) p).max((x, y) -> x.getExperienceYears() - y.getExperienceYears()).get().getExperienceYears();
//        maxDurations.addAll(persons.stream()
//                .filter(Worker.class::isInstance)
//                .map(p -> (Worker) p).filter(w -> w.getExperienceYears() == maxWorkYear).collect(Collectors.toList()));
//
//        return maxDurations;
//    }
}
