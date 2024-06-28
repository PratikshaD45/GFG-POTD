//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean isPalindrome(int[] array) {
            int left = 0;
            int right = array.length - 1;
            while (left < right) {
                if (array[left] != array[right]) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    public String pattern(int[][] arr) {
        int n = arr.length;
        // Check rows
        for (int i = 0; i < n; i++) {
            if (isPalindrome(arr[i])) {
                return i + " R";
            }
        }

        // Check columns
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = arr[i][j];
            }
            if (isPalindrome(column)) {
                return j + " C";
            }
        }

        // No palindrome found
        return "-1";
    }

}
