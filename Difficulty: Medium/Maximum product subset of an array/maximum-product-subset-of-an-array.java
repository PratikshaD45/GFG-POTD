//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        // code here
        long mod = 1000000007;
        int n = arr.size();
        if(n==1){
            return arr.get(0)%mod;
        }
        int iszero = 0;
        long ans = 1;
        //long maxpos = 1;
        int neg =0;
        int pos = 0;
        int maxnegative = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            if(arr.get(i)<0){
                ans = (ans*arr.get(i))%mod;
                neg++;
                maxnegative = Math.max(maxnegative,arr.get(i));
            }
            else{
                if(arr.get(i)!=0){
                    ans = (ans*arr.get(i))%mod;
                    pos++;
                }else{
                     iszero++;
                }
            }
        }
        
        if(iszero==n){
            return 0;
        }
        if(neg%2 != 0){
            if(neg==1 && iszero != 0 &&iszero + neg==n)
                return 0;
            ans = (ans/maxnegative)%mod;
        }
        
        return ans;
    }
}