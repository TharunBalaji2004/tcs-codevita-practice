package StaircaseProblem;

import java.util.*;

public class Staircase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(findWays2(n));

        sc.close();
    }

    private static int findWays1(int n){
        if (n <= 2) return n;
        else return findWays1(n - 1) + findWays1(n - 2);
    }

    private static int findWays2(int n){
        int[] arr = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;

        for (int i=2;i<n+2;i++){
            arr[i] = arr[i-1] + arr[i-2];
        }

        return arr[arr.length-1];
    }   
}
