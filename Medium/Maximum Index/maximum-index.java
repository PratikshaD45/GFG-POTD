//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends

class Solution {
    // Function to find the maximum index difference.
    int maxIndexDiff(int[] a, int n) { 
        // Your code here
        int[] preMin = new int[n];
        int[] suffMax = new int[n];
        
        int maxi = a[n-1];
        for (int i = n-1; i >= 0; i--) {
            maxi = Math.max(maxi, a[i]);
            suffMax[i] = maxi;
        }
        
        int mini = a[0];
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, a[i]);
            preMin[i] = mini;
        }
        
        int i = 0, j = 0;
        int ans = -1;
        while (i < n && j < n) {
            if (preMin[i] <= suffMax[j]) {
                ans = Math.max(ans, j - i);
                j++;
            } else {
                i++;
            }
        }
        return ans;
    }
}


