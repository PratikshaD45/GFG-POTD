//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    ArrayList<Integer> search(String pattern, String text) {
        ArrayList<Integer> res = new ArrayList<>();
        int q = 101;
        int d = 26;
        int M = pattern.length();
        int N = text.length();
        int p = 0;
        int t = 0;
        int h = 1;

        // h = (int) Math.pow(d, M - 1) % q;
        for (int i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // calculate the hash value of pattern and the first window of text
        for (int i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // slide the pattern over the text one by one
        for (int i = 0; i <= N - M; i++) {
            // check the hash if they are equal
            if (p == t) {
                // check for characters one by one
                int j = 0;
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == M) {
                    res.add(i + 1);
                }
            }
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;
                if (t < 0) {
                    t = t + q;
                }
            }
        }
        return res;
    }
}
