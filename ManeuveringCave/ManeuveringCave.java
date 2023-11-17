package ManeuveringCave;

import java.util.*;

public class ManeuveringCave {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0){
            int rows = sc.nextInt();
            int cols = sc.nextInt();

            int res = findWays(rows, cols);
        
            System.out.println(res);
        }
        sc.close();
    }

    // (row-1, col) represents bottom to top 
    // (row, col-1) represents right to left
    private static int findWays(int row, int col) {
        if (row == 1 || col == 1) return 1;
        return findWays(row - 1, col) + findWays(row, col - 1);
    }
}
