import java.util.*;

public class CivilWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        
        // Use generic type for the List
        List<Integer> powers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            powers.add(scanner.nextInt());
        }

        scanner.close();
        int teamAPower = 0;
        int teamBPower = 0;

        // Sort the powers
        Collections.sort(powers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int absA = Math.abs(a);
                int absB = Math.abs(b);
                if (absA == absB) {
                    return Integer.compare(b, a); // Invert order if absolute values are equal
                }
                return Integer.compare(absB, absA);
            }
        });

        boolean ironmanTurn = true;

        for (int i = 0; i < N; i++) {
            if (ironmanTurn) {
                teamAPower += powers.get(i);
            } else {
                teamBPower += powers.get(i);
            }
            ironmanTurn = !ironmanTurn;
        }

        int powerDifference = Math.abs(teamAPower - teamBPower);
        System.out.println(powerDifference);
    }
}
