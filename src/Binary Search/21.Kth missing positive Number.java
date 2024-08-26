https://leetcode.com/problems/kth-missing-positive-number/description/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        for(int i=0;i<n;i++)
        {
            if(arr[i]<=k) k++;
            else break;
        }
        return k;
    }
}

//Method-2:

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=arr.length;
        int ans=missing(arr, n, k);
        return ans;
    }

    public int missing(int[] arr, int n, int k)
    {
        int low=0, high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k) low=mid+1;
            else high=mid-1;

        }
        return k+high+1;
    }
}