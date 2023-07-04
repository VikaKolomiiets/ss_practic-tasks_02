package question04;

import java.math.BigDecimal;
import java.util.*;

public class Employee {
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.setName(name);
        this.setExperience(experience);
        this.setBasePayment(basePayment);
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getBasePayment() {
        return basePayment;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new NullPointerException("Please, check the Name.");
        }
        this.name = name;
    }

    public void setExperience(int experience) {
        if (experience < 0) {
            throw new IllegalArgumentException("Experience data cannot be less than zero.");
        }
        this.experience = experience;
    }

    public void setBasePayment(BigDecimal basePayment) {
        if (basePayment == null) {
            throw new NullPointerException("Please, check the basePayment data");
        }
        if (basePayment.doubleValue() <= 0) {
            throw new IllegalArgumentException("BasePayment should be more than zero");
        }
        this.basePayment = basePayment;
    }

    public BigDecimal getPayment() {
        return basePayment;
        //return this.getBasePayment().multiply(BigDecimal.valueOf(this.getExperience()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        //return experience == employee.experience && name.equals(employee.name) && basePayment.equals(employee.basePayment);
        return name.equalsIgnoreCase(employee.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

//    public Map<Integer,Double> getPayment(){
//        Map<Integer,Double> data = new HashMap<>();
//        data.put(this.getExperience(),this.getBasePayment().doubleValue() * this.getExperience());
//        return data;
//    }
