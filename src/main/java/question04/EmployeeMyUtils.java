package question04;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMyUtils {
    public static List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> selectedWorkers = new ArrayList<>();

        BigDecimal maxManagerPayment = workers.stream()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .max((x, y) -> (x.getPayment().subtract(y.getPayment())).intValue())
                .get().getPayment();
        int maxManagerExperience = workers.stream()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .max((x, y) -> (x.getExperience() - y.getExperience()))
                .get().getExperience();
        selectedWorkers.addAll(workers.stream()
                .filter(Manager.class::isInstance)
                .map(e -> (Manager) e)
                .filter(m -> m.getPayment().equals(maxManagerPayment) || m.getExperience() == maxManagerExperience)
                .distinct().toList());
        BigDecimal maxEmployeePayment = workers.stream()
                .filter(Employee.class::isInstance)
                .map(e -> (Employee) e)
                .max((x, y) -> (x.getPayment().subtract(y.getPayment())).intValue())
                .get().getPayment();
        int maxEmployeeExperience = workers.stream()
                .filter(Employee.class::isInstance)
                .map(e -> (Employee) e)
                .max((x, y) -> x.getExperience() - y.getExperience())
                .get().getExperience();
        selectedWorkers.addAll(workers.stream()
                .filter(Employee.class::isInstance)
                .map(e -> (Employee) e)
                .filter(e -> e.getExperience() == maxEmployeeExperience || e.getPayment().equals(maxEmployeePayment))
                .distinct().toList());

        return selectedWorkers;
    }
}
