import java.util.*; 

public class GroovingMonkeys {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);   

        int t = sc.nextInt();   

        while(t-- > 0) {
            int n = sc.nextInt();   
            int[] monkeys = new int[n];   

            for (int i = 0; i < n; i++) {
                monkeys[i] = sc.nextInt();   
            }

            System.out.println(naiveApproach(monkeys));
        }

        sc.close();
    }

    // TC: O(N^2) and SC: O(N)
    public static int naiveApproach(int[] monkeys) {
        int[] values = new int[monkeys.length];
        for (int i=0;i<values.length;i++) {
            values[i] = i+1;
        }

        int[] original = values;
        int count = 0;

        while(true) {
            int[] z = new int[monkeys.length];  

            for(int i = 0;i < monkeys.length;i++) {
                z[monkeys[i]-1] = values[i];
            }

            count += 1;

            if (Arrays.equals(original, z)) {
                return count;
            } else {
                values = z;
            }
        }
    }
}
