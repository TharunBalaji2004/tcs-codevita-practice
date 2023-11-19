package DivineDivisors;

import java.util.*;

public class DivineDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        printFactor(num);

        sc.close();
    }

    // TC: O(N) and SC: O(1)
    private static void printFactor(int num) {
        for (int i=1;i<=num;i++){
            if (num%i == 0) System.out.print(i + " ");
        }
    }
}
