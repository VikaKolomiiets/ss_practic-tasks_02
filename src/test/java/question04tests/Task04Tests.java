package question04tests;

import org.junit.jupiter.api.Test;
import question03.Person;
import question03.Student;
import question03.Worker;
import question04.Employee;
import question04.EmployeeMyUtils;
import question04.Manager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Task04Tests {

    @Test
    public void testUtils(){
        List<Employee> originList = new ArrayList();
        BigDecimal bd1 = new BigDecimal(425.25);
        BigDecimal bd2 = new BigDecimal(1425.25);
        BigDecimal bd3 = new BigDecimal(2425.25);
        originList.add(new Employee("Goff", 10, new BigDecimal(1425.25)));
        originList.add(new Employee("Goff", 8, new BigDecimal(1425.25)));
        originList.add(new Employee("Goff", 2, new BigDecimal(4425.25)));
        originList.add(new Manager("Goff", 10, new BigDecimal(1425.25), 1.5));
        originList.add(new Employee("Goff", 10, new BigDecimal(4425.25)));
        originList.add(new Employee("Goff", 15, new BigDecimal(1425.25)));
        originList.add(new Employee("Goff", 12, new BigDecimal(5425.25)));
        originList.add(new Manager("Goff", 10, new BigDecimal(1425.25), 1.5));
        originList.add(new Manager("Kate", 12, new BigDecimal(1425.25), 1.8));
        originList.add(new Manager("Goff", 15, new BigDecimal(1425.25), 1.2));
        ArrayList<Employee> employees = new ArrayList<>();
        employees.addAll(EmployeeMyUtils.largestEmployees(originList));
        for (Employee worker: employees) {
            System.out.println(worker.getClass().getName() + " : " +
                    worker.getName() + " : " + worker.getPayment() + " : " + worker.getExperience());
        }

    }
}
