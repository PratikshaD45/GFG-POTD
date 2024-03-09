//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        char[] chars = s.toCharArray();

        for (int i = 0; i < r; i++) {
            char[] newChars = new char[s.length() * 2];

            for (int j = 0; j < s.length(); j++) {
                if (chars[j] == '1') {
                    newChars[2 * j] = '1';
                    newChars[2 * j + 1] = '0';
                } else {
                    newChars[2 * j] = '0';
                    newChars[2 * j + 1] = '1';
                }
            }

            chars = newChars;
        }

        char ans = '\0';  // Default value in case n is out of bounds

        if (n < s.length() * Math.pow(2, r)) {
            ans = chars[n];
        }

        return ans;
    }
}
