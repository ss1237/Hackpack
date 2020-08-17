//find least common subsequence between two strings
import java.util.*;
import java.io.*;

public class LCS {
    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s1 = in.next();
        String s2 = in.next();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        String ans = "";
        int i = s1.length(), j = s2.length();
        while (dp[i][j] != 0) {
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            }
            else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            }
            else {
                i--;
                j--;
                ans = s1.charAt(i) + ans;
            }
        }
        out.println(ans);
        out.close();

    }
}
