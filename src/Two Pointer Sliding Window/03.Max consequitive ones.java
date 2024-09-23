https://leetcode.com/problems/max-consecutive-ones-iii/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int i=0; int j=0; int ans=0;
        int zeros=0;
        while( j<n)
        {
            if(nums[j]==0)  zeros++;

            while(zeros>k)
            {
                if(nums[i]==0)  zeros--;
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}