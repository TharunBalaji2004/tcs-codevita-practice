import java.util.*;

public class MinimizingTheSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] numbers = new int[n];

        for (int i=0;i<n;i++) numbers[i] = sc.nextInt();

        System.out.println(minimize(numbers, n, k));

        sc.close();
    }

    private static int minimize(int[] numbers, int n, int k) { 
        int minSum = 9999999;

        while (k-- > 0) {
            int[] res = findMaximum(numbers);
            int maxIndex = res[1];

            numbers[maxIndex] = (int) Math.floor(numbers[maxIndex]/2.0);
            int curSum = findSum(numbers);

            minSum = Math.min(minSum, curSum);
        }

        return minSum;
    }

    private static int[] findMaximum(int[] arr) {
        int[] res = new int[2];

        for (int i=0;i<arr.length;i++) {
            if (arr[i] > res[0]) {
                res[0] = arr[i];
                res[1] = i;
            }
        }

        return res;
    }

    private static int findSum(int[] arr) {
        int sum = 0;

        for (int i=0;i<arr.length;i++) sum += arr[i];

        return sum;
    }
}
