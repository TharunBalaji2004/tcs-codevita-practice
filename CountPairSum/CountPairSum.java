package CountPairSum;

import java.util.*;

public class CountPairSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] numbers = new int[n];

        for (int i=0;i<n;i++) numbers[i] = sc.nextInt();

        sc.close();

        System.out.println(countPairSum(numbers, n, k));
    }

    private static int countPairSum(int[] numbers, int n, int k) {
        int happyCount = 0;

        for (int i=0;i<n;i++) {
            int x = numbers[i];

            int start = x-k;
            int end = x+k;

            for (int pos=0;pos<n;pos++) {
                if (pos == i) continue;

                if (numbers[pos] >= start && numbers[pos] <= end) {
                    happyCount++;
                    break;
                }
            }
        }

        return happyCount;
    }
}
