//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int node, ArrayList<Integer> adj[], boolean visited[]){
        visited[node] = true;
        for(int i=0; i<adj[node].size(); i++){
            if(!visited[adj[node].get(i)]){
                dfs(adj[node].get(i), adj, visited);
            }
        }
    }
    public int isCircle(String arr[]) {
        // code here
        //create edges
        //adjacency list
        //a-z, a-0, b-1, c-2.......z-25
        ArrayList<Integer> adj[]= new ArrayList[26];
        int InDegree[] = new int[26];
        int OutDegree[] = new int[26];
        
        for(int i=0; i<26; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i=0; i<arr.length; i++){
            String temp = arr[i];
            int u = temp.charAt(0) - 'a';
            int v = temp.charAt(temp.length() - 1)- 'a';
            adj[u].add(v);
            OutDegree[u]++;
            InDegree[v]++;
        }
        
        //Elurian circuit
        for(int i=0; i<26; i++){
            if(InDegree[i] != OutDegree[i]){
                return 0;
            }
        }
        
        //All the edges are part of one components
        boolean visited[] = new boolean[26];
        int node = arr[0].charAt(0) - 'a';
        dfs(node, adj, visited);
        for(int i=0; i<26; i++){
            if(InDegree[i] > 0 && !visited[i]){
                return 0;
            }
        }
        return 1;
    }
}