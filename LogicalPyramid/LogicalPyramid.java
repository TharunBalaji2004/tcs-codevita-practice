package LogicalPyramid;

import java.util.*;

public class LogicalPyramid {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
       
        int n = sc.nextInt();

        printPattern(n);
        sc.close();
    }

    private static void printPattern(int n){
        List<Integer> numbers = findElements(n);
        List<Integer> res = new ArrayList<>();
        int curr = 6;

        for(int i=0;i<numbers.size();i++){
            res.add(curr + numbers.get(i));
            curr += numbers.get(i);
        }   

        int pos = 0;
        int count = 1;
        for (int i=0;i<n;i++){
            for (int j=1;j<=count;j++) {
                for (int k=0;k<5-i-1;k++) System.out.print("0");
                System.out.print(res.get(pos++) + " ");
            }
            count++;
            System.out.println();
        }

    }

    private static List<Integer> findElements(int n) {
        int a = 22;
        int d = 16;
        int elements = ((n*(n+1))/2);
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);

        for(int i=0;i<elements - 1;i++) {
            int an = a + (i)*d;
            numbers.add(an);
        }

        return numbers;
    }
}
