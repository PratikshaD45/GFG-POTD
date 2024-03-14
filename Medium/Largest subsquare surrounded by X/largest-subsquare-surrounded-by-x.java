//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            char A[][] = new char[N][N];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().trim().split(" ");
                for (int j = 0; j < N; j++) A[i][j] = S[j].charAt(0);
            }
            Solution ob = new Solution();
            System.out.println(ob.largestSubsquare(N, A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    int largestSubsquare(int n, char[][] a) {
        // We will be creating matrices for rows and columns
        int[][] by_rows = new int[n][n];
        int[][] by_cols = new int[n][n];

        // Populate the matrix by_rows
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 'X') {
                    row++;
                } else {
                    row = 0;
                }
                by_rows[i][j] = row;
            }
        }

        // Populate the matrix by_cols
        for (int i = 0; i < n; i++) {
            int col = 0;
            for (int j = 0; j < n; j++) {
                if (a[j][i] == 'X') {
                    col++;
                } else {
                    col = 0;
                }
                by_cols[j][i] = col;
            }
        }

        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int side = Math.min(by_rows[i][j], by_cols[i][j]);
                while (side > res) {
                    if (by_rows[i - side + 1][j] >= side && by_cols[i][j - side + 1] >= side) {
                        res = side;
                    } else {
                        side--;
                    }
                }
            }
        }
        return res;
    }
}
