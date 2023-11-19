package ManeuveringCave;

import java.util.*;

public class ManeuveringCave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();

            int res = findWaysDP(rows, cols);
        
            System.out.println(res);
        }
        sc.close();
    }

    private static int findWaysDP(int rows, int cols) {
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < cols; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[rows - 1][cols - 1];
    }
}
