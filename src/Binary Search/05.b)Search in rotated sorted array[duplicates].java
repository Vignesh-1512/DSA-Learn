https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
                return true;
        }
        return false;
    }
}

//Method-2:

class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int low=0, high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;

            if(nums[mid]==target) return true;

            //Edge case:
            if(nums[low]==nums[mid]&&nums[mid]==nums[high])
            {
                low=low+1;
                high=high-1;
                continue;
            }

            //if left side is sorted
            if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target && target<=nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            else
            { // if right side is sorted
                if(nums[mid]<=target && target<=nums[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return false;
    }
}