package SeatingArrangement;

import java.util.*;

public class SeatingArrangement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r  = sc.nextInt();

        sc.close();

        int res = (int)(fact(n)/(fact(n-r)*fact(r)));
    
        System.out.println(res);
    }

    private static int fact(int n){
        if (n == 1) return 1;
        else return n * fact(n-1);
    }
}
