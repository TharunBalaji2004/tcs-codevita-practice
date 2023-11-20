package ExchangeDigit;

import java.util.*;

public class ExchangeDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] line = sc.nextLine().split(" ");
        String num = line[0];
        int num2 = Integer.parseInt(line[1]);

        List<Integer> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        boolean[] map = new boolean[num.length()];
        
        permute(num, ds, map, ans);

        int curr = Integer.MAX_VALUE;
        for (int n: ans) {
            if (n > num2) {
                curr = Math.min(n, curr);
            }
        }

        System.out.println(curr);

        sc.close();
    }

    private static void permute(String num, StringBuilder ds, boolean[] map, List<Integer> ans) {
        if (ds.length() == num.length()) {
            ans.add(Integer.parseInt(ds.toString()));
            return;
        }

        for (int i=0;i<map.length;i++){
            if (!map[i]) {
                map[i] = true;
                ds.append(num.charAt(i));

                permute(num, ds, map, ans);

                map[i] = false;
                ds.deleteCharAt(ds.length() - 1);
            }
        }
    }
    
}
