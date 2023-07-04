package question04;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class EmployeeMyUtils {
    public static List<Employee> largestEmployees2(List<Employee> workers) {
        if(workers == null)
        {
            throw new NullPointerException();
        }
        List<Employee> selectedWorkers = new ArrayList<>();

        int maxManagerExperience = workers.stream().distinct()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .max((x, y) -> (x.getExperience() - y.getExperience()))
                .get().getExperience();
        selectedWorkers.addAll(workers.stream()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .filter(m -> m.getExperience() == maxManagerExperience)
                .distinct().toList());

        int maxEmployeeExperience = workers.stream().distinct()
                .filter(Employee.class::isInstance)
                .map(e -> (Employee) e)
                .max((x, y) -> x.getExperience() - y.getExperience())
                .get().getExperience();
        selectedWorkers.addAll(workers.stream()
                .filter(Employee.class::isInstance)
                .map(e -> (Employee) e)
                .filter(e -> e.getExperience() == maxEmployeeExperience)
                .distinct().toList());

        BigDecimal maxPayment = workers.stream().distinct()
                .max((x, y) -> (x.getPayment().subtract(y.getPayment())).intValue())
                .get().getPayment();

        selectedWorkers.addAll(workers.stream()
                .filter(e -> e.getPayment() == maxPayment)
                .distinct().toList());

        return selectedWorkers.stream().distinct().toList();
    }




    public static List<Employee> largestEmployees(List<Employee> workers) {
        if(workers == null)
        {
            throw new NullPointerException();
        }
        List<Employee> selectedWorkers = new ArrayList<>();

        BigDecimal maxManagerPayment = workers.stream().distinct()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .max((x, y) -> (x.getPayment().subtract(y.getPayment())).intValue())
                .get().getPayment();
        int maxManagerExperience = workers.stream().distinct()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .max((x, y) -> (x.getExperience() - y.getExperience()))
                .get().getExperience();
        selectedWorkers.addAll(workers.stream()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .filter(m -> m.getPayment().equals(maxManagerPayment) || m.getExperience() == maxManagerExperience)
                .distinct().toList());

        BigDecimal maxEmployeePayment = workers.stream().distinct()
                .filter(w -> !(w instanceof Manager))
                .map(e -> (Employee) e)
                .max((x, y) -> (x.getPayment().subtract(y.getPayment())).intValue())
                .get()
                .getPayment();
        int maxEmployeeExperience = workers.stream().distinct()
                .filter(w -> !(w instanceof Manager))
                .map(e -> (Employee) e)
                .max((x, y) -> x.getExperience() - y.getExperience())
                .get().getExperience();
        selectedWorkers.addAll(workers.stream()
                .filter(w -> !(w instanceof Manager))
                .map(e -> (Employee) e)
                .filter(e -> e.getExperience() == maxEmployeeExperience || e.getPayment().equals(maxEmployeePayment))
                .distinct().toList());

        return selectedWorkers.stream().distinct().toList();
    }
}
