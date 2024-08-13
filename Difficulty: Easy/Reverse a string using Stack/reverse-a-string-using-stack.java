//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}

// } Driver Code Ends


class Solution {
    
    public String reverse(String s){
        //code here
        Stack<Character> stack=new Stack<>();
        int idx=0;
        while(idx<s.length()){
            stack.push(s.charAt(idx));
            idx++;
        }
        StringBuilder res = new StringBuilder("");
        while(!stack.isEmpty()){
            char curr = stack.pop();
            res.append(curr);
        }
        return res.toString();
    }

}