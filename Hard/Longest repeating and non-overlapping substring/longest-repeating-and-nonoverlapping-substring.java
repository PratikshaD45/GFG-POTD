//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution {
    public String longestSubstring(String s, int n) {
        // code here
        int[][] dp = new int[n + 1][n + 1];
        int resLength = 0;
        int i, index = 0;

        for (i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j - i > dp[i - 1][j - 1] && s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > resLength) {
                        resLength = dp[i][j];
                        index = Math.max(i, index);
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        if (resLength > 0) {
            for (i = index - resLength + 1; i <= index; i++) {
                res.append(s.charAt(i - 1));
            }
        }

        if (res.toString().equals("")) {
            return "-1";
        }

        return res.toString();
    }
}
