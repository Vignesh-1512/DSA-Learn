https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]+nums[j]==target)
                {
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        ans[0]=ans[1]=-1;
        Map<Integer, Integer> mpp=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];

            int more=target-num;
            if(mpp.containsKey(more)){
                ans[0]=mpp.get(more);
                ans[1]=i;
                return ans;
            }

            mpp.put(nums[i],i);
        }
        return ans;
    }
}