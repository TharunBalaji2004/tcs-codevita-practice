import java.util.Scanner;   

public class CountingRocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int r = sc.nextInt();
        int[] samples = new int[s];
        int[] ans = new int[r];
        int pos = 0;

        for (int i =0;i<s;i++) {
            samples[i] = sc.nextInt();
        }

        for (int i=0;i<r;i++) {
            int count = 0;
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j=0;j<s;j++) {
                if (samples[j] >= start && samples[j] <= end) {
                    count++;
                }
            }
            
            ans[pos++] = count;
        }

        for (int index=0;index<r;index++) {
            System.out.print(ans[index] + " ");
        }

        sc.close();
    }
}
