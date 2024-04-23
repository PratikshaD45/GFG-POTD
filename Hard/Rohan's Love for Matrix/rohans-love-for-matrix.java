//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int firstElement(int n) {
        // code here
        int mod=1000000007;
        int a10=1;
        int a11=0;
        for(int i=2; i<=n; i++){
            int tempa10=a10;
            a10=(a10+a11)%mod;
            a11=(tempa10)%mod;
          
            
        }
        return a10;
    }
}