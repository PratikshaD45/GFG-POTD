//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) 
    { 
          // 0 1 kanpsack Tabulation

        int dp[][] = new int[n + 1][w + 1];
        //print(dp);
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0; // 0th col
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; // 0th row
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                int v = val[i - 1];
                int W = wt[i - 1];

                if (W <= j) { // valid
                    // include
                    int incProfit = v + dp[i - 1][j-W];
                    // exclude
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);

                } else {

                    // Invalid
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
              

            }
             
        }
    
        return dp[n][w];
        
        
    }

}


