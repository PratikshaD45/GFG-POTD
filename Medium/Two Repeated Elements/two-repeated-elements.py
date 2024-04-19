#User function Template for python3

class Solution:
    
    #Function to find two repeated elements.
    def twoRepeated(self, nums , n):
        slw,fas=0,0
        while(slw!=fas or slw==0):
            slw=nums[slw]
            fas=nums[nums[fas]]
        slw=0
        
        while(slw!=fas):
            slw=nums[slw]
            fas=nums[fas]
        x=slw
        y=sum(nums)-(n*(n+1)//2)-x
        c1,c2=0,0
        for i in range(n+2):
            if(nums[i]==x):
                if(c1==0):
                    c1=1
                else:
                    return(x,y)
            elif(nums[i]==y):
                if(c2==0):
                    c2=1
                else:
                    return(y,x)


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math

def main():
        T=int(input())
        while(T>0):
            
            N=int(input())

            A=[int(x) for x in input().strip().split()]
            
            obj = Solution()
            ans = obj.twoRepeated(A,N)
            print(ans[0], ans[1])
            
            T-=1


if __name__ == "__main__":
    main()
# } Driver Code Ends