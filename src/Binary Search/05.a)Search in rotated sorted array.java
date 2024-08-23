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
