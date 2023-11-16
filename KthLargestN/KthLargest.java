package KthLargestN;

import java.util.*; 

public class KthLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(findFactors(n, k));

        sc.close();
    }

    private static int findFactors(int num, int k){
        List<Integer> factors = new ArrayList<>();   

        for (int i=1;i<=num/2;i++){
            if (num%i==0) factors.add(i);   
        }

        if (k > factors.size()) return 1; 

        return factors.get(factors.size()-k+1); 
    }
}
