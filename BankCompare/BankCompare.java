package BankCompare;

import java.util.*;

public class BankCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double banks[] = new double[2];

        double principal = sc.nextDouble();
        int year = sc.nextInt();
        int count = 0;

        while (count < 2) {
            int installments = sc.nextInt();
            double sum = 0;

            for (int i=0;i<installments;i++) {
                int time = sc.nextInt();
                double rate = sc.nextDouble();    

                double sqaure = Math.pow((1+rate), time*12);
                double emi = (principal*(rate)/(1-1/sqaure));    

                sum += emi; 
            }

            banks[count++] = sum;
        }

        if (banks[0] < banks[1]) System.out.println("Bank A");
        else System.out.println("Bank B");

        sc.close();
    }
}
