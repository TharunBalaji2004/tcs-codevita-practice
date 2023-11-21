package CoinDistribution;

import java.util.Scanner;

public class CoinDistribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while (i <= n) {
            int f = (i - 4) / 5;
            int o = 1;
            if ((i - 5 * f) % 2 == 0) {
                o = 2;
            }
            int t = (i - 5 * f - o) / 2;
            System.out.println(i + " " + (f + t + o) + " " + f + " " + t + " " + o);
            i += 1;
        }
        sc.close();
    }
}
