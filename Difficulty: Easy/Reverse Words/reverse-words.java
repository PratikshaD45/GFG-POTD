//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        StringBuilder str=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        int n=S.length();
        
        for(int i=n-1; i>=0; i--){
          
            if(S.charAt(i)=='.'){
                str.append(sb.reverse().toString());
                str.append('.');
                sb.setLength(0);
            }else{
                sb.append(S.charAt(i));
            }
           
            
        }
        sb.reverse();
        str.append(sb);
        return str.toString();
    }
}