import java.util.*;

public class ConsecutivePrimeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        for (int i=5; i<=n;i++) {
            if (isPrime(i) && findPrimeSum(i)) {
                count++;
            }
        }
        
        System.out.println(count);
        sc.close();
    }

    private static boolean findPrimeSum(int n) {
        int sum = 0;
        int i = 2;
        while (i < n) {
            if (isPrime(i)) {
                sum += i;
                if (sum == n) {
                    return true;
                }
            }
            i++;
        }
        return false;
    } 

    private static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}