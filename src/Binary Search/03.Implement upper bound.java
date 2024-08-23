https://www.naukri.com/code360/problems/implement-upper-bound_8165383?leftPanelTabValue=PROBLEM

public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        int ans=x;
        int low=0, high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}

//Brute Method:

public class Solution {
    public static int lowerBound(int []arr, int n, int x) {
        // Write your code here
        if(x==0) return 0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>=x)
                return i;
        }
        return x;
    }
}