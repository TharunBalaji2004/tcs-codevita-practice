import java.util.*;

public class CollectingCandies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] candies = new int[n];

        for (int i=0;i<n;i++) candies[i] = sc.nextInt();

        Arrays.sort(candies);

        int timeTaken = candies[0];
        int res = 0;

        for (int i=1;i<candies.length;i++) {
            timeTaken += candies[i];
            res += timeTaken;
        }

        System.out.println(res);

        sc.close();
    }
}