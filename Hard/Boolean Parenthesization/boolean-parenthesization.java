//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static final int MOD = 1003;
    
    static int countWays(int n, String s) {
        int[][] dpTrue = new int[n][n];
        int[][] dpFalse = new int[n][n];
        
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dpTrue[i][j] = (s.charAt(i) == 'T') ? 1 : 0;
                    dpFalse[i][j] = (s.charAt(i) == 'F') ? 1 : 0;
                } else if (gap == 1) {
                    dpTrue[i][j] = (s.charAt(i) == 'T' && s.charAt(j) == 'T') ? 1 : 0;
                    dpFalse[i][j] = (s.charAt(i) == 'F' && s.charAt(j) == 'F') ? 1 : 0;
                } else {
                    for (int k = i + 1; k < j; k += 2) {
                        int leftTrue = dpTrue[i][k - 1];
                        int leftFalse = dpFalse[i][k - 1];
                        int rightTrue = dpTrue[k + 1][j];
                        int rightFalse = dpFalse[k + 1][j];
                        
                        if (s.charAt(k) == '&') {
                            dpTrue[i][j] += leftTrue * rightTrue % MOD;
                            dpFalse[i][j] += (leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse) % MOD;
                        } else if (s.charAt(k) == '|') {
                            dpTrue[i][j] += (leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue) % MOD;
                            dpFalse[i][j] += leftFalse * rightFalse % MOD;
                        } else if (s.charAt(k) == '^') {
                            dpTrue[i][j] += (leftTrue * rightFalse + leftFalse * rightTrue) % MOD;
                            dpFalse[i][j] += (leftTrue * rightTrue + leftFalse * rightFalse) % MOD;
                        }
                    }
                    dpTrue[i][j] %= MOD;
                    dpFalse[i][j] %= MOD;
                }
            }
        }
        
        return dpTrue[0][n - 1];
    }
}
