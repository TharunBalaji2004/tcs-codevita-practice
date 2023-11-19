package HousesProblem;

import java.util.*;

public class HousesProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int houses = sc.nextInt();
        int[] money = new int[houses];

        for (int i=0;i<houses;i++) money[i] = sc.nextInt();

        sc.close();

        System.out.println(robBest(money));
    }

    // TC: O(N) and SC: O(N)
    private static int robBest(int[] money) {
        if (money.length < 2) return money[0];

        int[] memo = new int[money.length];
        memo[0] = money[0];
        memo[1] = Math.max(money[0], money[1]);

        for (int i=2;i<money.length;i++){
            memo[i] = Math.max(memo[i-2] + money[i], memo[i-1]);
        }

        return memo[memo.length - 1];
    }

    // TC: O(N) and SC: O(1)
    private static int robOptimal(int[] money) {
        if (money.length < 2) return money[0];

        int prev2 = money[0];
        int prev1 = Math.max(money[0], money[1]);
        int res = prev1;

        for (int i=2;i<money.length;i++){
            res = Math.max(money[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = res;
        }

        return res;
    }
}
