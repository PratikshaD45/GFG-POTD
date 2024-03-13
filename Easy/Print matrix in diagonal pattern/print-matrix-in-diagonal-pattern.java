//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        List<Integer> ansList = new ArrayList<>();
        int row = 0, col = 0;
        int n = mat.length;

        while (ansList.size() < n * n) {
            // Going upward diagonally till my first row or my last column is reached
            while (row >= 0 && col < n) {
                if (row >= 0 && col >= 0 && row < n && col < n) {
                    ansList.add(mat[row][col]);
                    mat[row][col] = Integer.MAX_VALUE;
                }
                row--;
                col++;
            }
            if (ansList.size() == n * n) {
                break;
            }

            row = Math.max(row, 0);
            col = Math.min(col, n - 1);

            while (mat[row][col] == Integer.MAX_VALUE) {
                row++;
            }

            // Going diagonally downwards
            while (col >= 0 && row < n) {
                if (row >= 0 && col >= 0 && row < n && col < n) {
                    ansList.add(mat[row][col]);
                    mat[row][col] = Integer.MAX_VALUE;
                }
                row++;
                col--;
            }
            if (ansList.size() == n * n) {
                break;
            }

            row = Math.min(row, n - 1);
            col = Math.max(col, 0);

            while (mat[row][col] == Integer.MAX_VALUE) {
                col++;
            }
        }

        // Convert List<Integer> to int[]
        int[] ansArray = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            ansArray[i] = ansList.get(i);
        }

        return ansArray;
    }
}
