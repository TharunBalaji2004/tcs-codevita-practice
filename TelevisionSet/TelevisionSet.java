package TelevisionSet;

import java.util.*;

public class TelevisionSet {
    private static int rateOfPatients(int m, int d) {
        return (6 - m) * (6-m) + Math.abs(d - 15);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rooms = sc.nextInt();
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int revenue = sc.nextInt();

        System.out.println(calcTelevision(rooms, r1, r2, revenue));

        sc.close();
    }

    private static int calcTelevision(int rooms, int r1, int r2, int revenue) {
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int curr_target = 0, patientCount;

        for (int tvs = 0;tvs<=rooms;tvs++) {

            for (int month=1;month<=12;month++){
                for (int day=1;day <= days[month];day++) {
                    patientCount = rateOfPatients(month, day);

                    patientCount = Math.min(patientCount, rooms);
                    
                    // Rooms without TV
                    if (patientCount <= rooms - tvs) {
                        curr_target += patientCount*r1;
                    } else {
                        curr_target += ((rooms - tvs) * r2 + ((patientCount - (patientCount - tvs)) * r1));
                    }
                }
            }

            if (curr_target >= revenue) {
                return Math.min(tvs, rooms);
            }
        }

        return -1;
    }
}
