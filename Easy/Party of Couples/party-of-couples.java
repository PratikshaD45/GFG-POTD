//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.findSingle(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int findSingle(int n, int arr[]){
        // code here
       HashMap<Integer, Integer> map=new HashMap<>();
       for(int i=0; i<n; i++){
           if(map.containsKey(arr[i])){
               map.put(arr[i], map.get(arr[i])+1);
           }else{
               map.put(arr[i], 1);
           }
       }
       for(int val: map.keySet()){
           if(map.get(val)%2!=0){
               return val;
           }
       }
       return 0;
    }
}