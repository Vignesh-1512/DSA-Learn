https://leetcode.com/problems/find-peak-element/description/

class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if((i==0 || nums[i-1] < nums[i]) && (i==(n-1) || nums[i] > nums[i+1]))
            {
                return i;
            }
        }
        return -1;
    }
}

//Method-2:

class Solution {
    public int findPeakElement(int[] nums) {
        int n=nums.length;
        //Edge case:
        if(n==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[n-1]>nums[n-2]) return n-1;

        int low=1,high=n-2;
        while(low<=high)
        {
            int mid=(low+high)/2;

            if(nums[mid] > nums[mid-1] && nums[mid+1] < nums[mid])
            {
                return mid;
            }

            // If we are in the left: [Mid is in increasing Peak]
            if(nums[mid] > nums[mid-1]) low=mid+1;

                // If we are in the right: [mid is in decreasing peak]
            else high=mid-1;
        }
        return -1;
    }
}