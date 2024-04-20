//{ Driver Code Starts
//Initial template for C++

#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

class Solution {
  public:
    //Function to find two repeated elements.
    vector<int> twoRepeated (int arr[], int n) {
        // Your code here
        long long m = n;
        long long slow = arr[0];
        long long  fast = arr[0];
        do{
            slow = arr[slow];
            fast = arr[arr[fast]];
        }while(slow!=fast);
        fast = arr[0];
        while(slow!=fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        long long  num1 = slow;
        long long  sum = 0;
        for(int i = 0;i<n+2;i++){
            sum+= arr[i];
        }
        //cout<<sum<<endl;
        long long  num2 = abs(sum - ((m*(m+1))/2))-num1;
        int n1 = 0, n2 = 0;
        for(int i = 0;i<n+2;i++){
            if(arr[i]==num1){
               if(n1==0)
                n1 = 1;
                else
                    return {(int)num1,(int)num2};
            }
            else if(arr[i]==num2){
                 if(n2==0)
                    n2 = 1;
                else
                    return {(int)num2,(int)num1};
            }
        }
       
    }
};

//{ Driver Code Starts.

int main()
{
    int t,n;
    cin>>t;
    
    while(t--)
    {
        cin>>n;
        
        int a[n+2];
        
        for(int i=0;i<n+2;i++)
            cin>>a[i];
        
        Solution obj;
        vector<int> res;
        res = obj.twoRepeated(a, n);
        cout<<res[0]<<" "<<res[1]<<endl;
    }
    return 0;
}

// } Driver Code Ends