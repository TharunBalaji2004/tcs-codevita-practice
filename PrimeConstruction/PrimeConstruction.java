package PrimeConstruction;
import java.util.*; 

public class PrimeConstruction {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }

            System.out.println(naiveApproach(numbers));
        }

        sc.close();
    }

    public static int naiveApproach(int[] numbers) {
        int mini = numbers[0];

        for (int num: numbers){
            mini = Math.min(num, mini);
        }

        return lcmOfArray(numbers) + mini;    
    }

    private static int lcmOfArray(int[] numbers) {
        int lcm = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            lcm = lcm(lcm, numbers[i]);
        }

        return lcm;
    }

    private static int lcm(int a, int b){
        return Math.abs(a*b)/gcd(a,b);
    }

    private static int gcd(int a, int b){
        if (b == 0) return a;
        return gcd(b, a%b);
    }
}

