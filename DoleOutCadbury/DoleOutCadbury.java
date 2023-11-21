package DoleOutCadbury;

import java.util.*;

public class DoleOutCadbury {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        sc.close();

        int minL = Integer.parseInt(line[0]);
        int maxL = Integer.parseInt(line[1]);
        int minW = Integer.parseInt(line[2]);
        int maxW = Integer.parseInt(line[3]);

        int students = 0;

        for (int a=minL; a<=maxL;a++) {
            for (int b=minW; b<= maxW;b++){
                students += findCount(a, b);
            }
        }

        System.out.println(students);
    }

    private static int findCount(int l, int r) {
        if (l == 1) return r;
        if (r == 1) return l;
        if (l == r) return 1;

        if (l > r) return findCount(l - r, r) + 1;
        else return findCount(l, r - l) + 1; 
    }
}