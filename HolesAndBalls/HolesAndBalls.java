package HolesAndBalls;

import java.util.Scanner;

public class HolesAndBalls {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int b = sc.nextInt();
        int[] holes = new int[h];
        int[] balls = new int[b];

        for (int i = h - 1; i >= 0; i--) holes[i] = sc.nextInt();
        for (int i = 0; i < b; i++) balls[i] = sc.nextInt();

        sc.close();

        int[] res = new int[b];
        int[] capacity = new int[h];

        for (int ball = 0; ball < b; ball++) {
            boolean ballFell = false;
            for (int hole = h - 1; hole >= 0; hole--) {
                if (balls[ball] <= holes[hole] && capacity[hole] < hole + 1) {
                    capacity[hole] += 1;
                    res[ball] = hole + 1;
                    ballFell = true;
                    break;
                }
            }
            if (!ballFell) {
                res[ball] = 0; // Ball didn't fall into any hole
            }
        }

        System.out.print("Balls fell in: ");
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
