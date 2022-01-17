package tests;

import lombok.Data;

@Data
public class Salary {
    int from;
    int to;
    String currency;
    boolean gross;
    int averageSalary;

    public double getAverage(){
        return (from + to) / 2;

    }
}
