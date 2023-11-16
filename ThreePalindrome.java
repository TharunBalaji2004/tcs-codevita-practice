import java.util.*;

public class ThreePalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        int l = s.length();

        for (int i = 1; i < l - 1; i++) {
            String s1 = s.substring(0, i);
            if (isPalindrome(s1)) {
                for (int j = 1; i + j < l; j++) {
                    String s2 = s.substring(i, i + j);
                    String s3 = s.substring(i + j);
                    if (isPalindrome(s2) && isPalindrome(s3)) {
                        System.out.println(s1);
                        System.out.println(s2);
                        System.out.println(s3);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println("Impossible");
    }

    private static boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }
        String s1 = new StringBuilder(s).reverse().toString();
        return s1.equals(s);
    }
}
