//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().hasArrayTwoCandidates(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean hasArrayTwoCandidates(int arr[], int x) {
        // code here
        // HashSet<Integer> set=new HashSet<>();
        // for(int i=0; i<arr.length; i++){
        //     set.add(arr[i]);
        // }
        // for(int i=0; i<arr.length; i++){
        //     if(arr[i]>x){
        //         continue;
        //     }
        //     int rem=x-arr[i];
        //     if(set.contains(rem)){
        //         return true;
        //     }
        // }
        // return false;
        
        Arrays.sort(arr);
        int si=0;
        int ei=arr.length-1;
        while(si<ei){
            if((arr[si]+arr[ei])==x){
                return true;
            }else if((arr[si]+arr[ei])>x){
                ei--;
            }else{
                si++;
            }
        }
        return false;
    }
}