//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findCoverage(int[][] matrix) {
        // code here
        int n=matrix.length;
        int m=matrix[0].length;
        int count=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0;j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    if(i+1<n){
                        count+=matrix[i+1][j];
                    }
                    if(i-1>=0){
                        count+=matrix[i-1][j];
                    }
                    if(j+1<m){
                        count+=matrix[i][j+1];
                    }
                    if(j-1>=0){
                        count+=matrix[i][j-1];
                    }
                    
                }
            }
        }
        return count;
    }
}