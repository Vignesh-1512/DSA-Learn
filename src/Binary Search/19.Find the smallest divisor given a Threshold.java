https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,nums[i]);
        }

        //Find the smallest divisor:
        for(int d=1;d<=maxi;d++)
        {
            //To find summation of divisor
            int sum=0;
            for(int i=0;i<n;i++)
            {
                sum+=Math.ceil((double)nums[i]/(double)d);
            }
            if(sum<=threshold) return d;
        }
        return -1;
    }
}