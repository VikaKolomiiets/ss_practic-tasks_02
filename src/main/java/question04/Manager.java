package question04;

import java.math.BigDecimal;
import java.util.Objects;

public class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.setCoefficient(coefficient);
    }

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        if (coefficient <= 0) {
            throw new IllegalArgumentException("Coefficient should be more than 0");
        }
        this.coefficient = coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        return super.getPayment().multiply(BigDecimal.valueOf(this.getCoefficient()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return this.getExperience() == manager.getExperience()
                && Objects.equals(this.getName(), manager.getName())
                && Objects.equals(this.getPayment(), manager.getBasePayment());
    }

}

//    @Override
//    public Map<Integer, Double> getPayment() {
//        Map<Integer,Double> data = new HashMap<>();
//        data.put(this.getExperience(),this.getBasePayment().doubleValue() * this.getCoefficient() * this.getExperience());
//        return data;
//    }