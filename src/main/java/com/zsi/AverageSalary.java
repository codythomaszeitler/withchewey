package com.zsi;

public class AverageSalary {

    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int aggregate = 0;

        for (int i = 0; i < salary.length; i++) {
            int currentSalary = salary[i];

            if (currentSalary < min) {
                min = currentSalary;
            }

            if (currentSalary > max) {
                max = currentSalary;
            }

            aggregate += currentSalary;
        }

        double asDouble = aggregate - min - max;
        double average = asDouble / (salary.length - 2);
        return average;
    }

}
    
