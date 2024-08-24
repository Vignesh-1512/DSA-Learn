https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1365532859/

class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int ans=-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==target)
            {
                ans=i;
            }
        }
        return ans;
    }
}

//Method-2:


class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0, high=n-1;
        while(low <= high)
        {
            int mid=(low+high)/2;

            if(nums[mid]==target) return mid;

            //if left side is sorted

            if(nums[low]<=nums[mid])
            {
                if(nums[low]<=target && target <= nums[mid])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }

            else
            {
                //if right side is sorted
                if(nums[mid] <= target && target<=nums[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;
    }
}