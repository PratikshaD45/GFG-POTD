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
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int Mat[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    Mat[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.findMaxSum(N, M, Mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        int maxSum = Integer.MIN_VALUE;

        // Iterate through each cell of the matrix
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                // Calculate the sum of the hourglass centered at (i, j)
                int sum = mat[i][j] + mat[i][j + 1] + mat[i][j + 2] +
                          mat[i + 1][j + 1] +
                          mat[i + 2][j] + mat[i + 2][j + 1] + mat[i + 2][j + 2];

                // Update maxSum if the current sum is greater
                maxSum = Math.max(maxSum, sum);
            }
        }

        // If no hourglass is found, return -1
        if (maxSum == Integer.MIN_VALUE) {
            return -1;
        }

        return maxSum;
    }
}
