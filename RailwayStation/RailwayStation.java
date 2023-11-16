package RailwayStation;

import java.util.*;

public class RailwayStation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arrival = new int[n];
        int[] depart = new int[n];
        
        for (int i=0;i<n;i++) {
            arrival[i] = sc.nextInt();
            depart[i] = sc.nextInt() + arrival[i];
        }

        System.out.println(minPlatforms(n, arrival, depart));

        sc.close();
    }

    private static int minPlatforms(int n, int[] arrival, int[] depart) {
        Arrays.sort(arrival);
        Arrays.sort(depart);

        int platforms = 1, maxPlatforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arrival[i] <= depart[j]) {
                platforms++;
                i++;
            } else if (arrival[i] > depart[j]) {
                platforms--;
                j++;
            }
            
            if (platforms > maxPlatforms) maxPlatforms = platforms;
        }

        return maxPlatforms;
    }
}
