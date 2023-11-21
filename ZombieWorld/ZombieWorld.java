package ZombieWorld;

import java.util.*;

public class ZombieWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int b = sc.nextInt();
        int n = sc.nextInt();
        int[] zombies = new int[n];

        for (int i=0;i<n;i++) zombies[i] = sc.nextInt();

        for (int i=0;i<n;i++) {
            b -= (zombies[i]%2) + (zombies[i]/2);
        }

        if (b > 0) System.out.println("YES");
        else System.out.println("NO");

        sc.close();
    }
}
