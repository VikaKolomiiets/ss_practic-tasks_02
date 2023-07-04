package question04;

import com.sun.jdi.Value;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(name == null || name.isEmpty()){
            throw new NullPointerException("Please, check the Name.");
        }
        this.name = name;
    }
    public void setExperience(int experience) {
        if(experience < 0){
            throw new IllegalArgumentException("Experience data cannot be less than zero.");
        }
        this.experience = experience;
    }
    public void setBasePayment(BigDecimal basePayment) {
        if(basePayment == null){
            throw new NullPointerException("Please, check the basePayment data");
        }
        if(basePayment.doubleValue() <= 0){
            throw new IllegalArgumentException("BasePayment should be more than zero");
        }
        this.basePayment = basePayment;
    }
//    public Map<Integer,Double> getPayment(){
//        Map<Integer,Double> data = new HashMap<>();
//        data.put(this.getExperience(),this.getBasePayment().doubleValue() * this.getExperience());
//        return data;
//    }

    public Double getPaument(){
        return this.getBasePayment().doubleValue() * this.getExperience();
    }

}
