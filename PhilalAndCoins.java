import java.util.*;

public class PhilalAndCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int coins = sc.nextInt();
            System.out.println(naiveApproach(coins));
        }

        sc.close();
    }

    // TC: O(log n) and SC: O(log n)
    public static int naiveApproach(int coins) {
        if (coins == 1) return 1;

        int res = (int) Math.ceil(coins / 2);
        return 1 + naiveApproach(res);
    }   

    
    // TC: O(1) and SC: O(1)
    public static int optimalApproach(int coins) {
        return (int)Math.ceil(Math.log(coins) / Math.log(2));
    }
}
