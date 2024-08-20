https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(nums[i]==nums[j])
                {
                    count++;
                }
            }

            if(count>(n/2)) return nums[i];
        }
        return -1;
    }
}
/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */

class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> mpp=new HashMap<>();

        for(int i=0;i<n;i++)
        {
            int value=mpp.getOrDefault(nums[i],0);
            mpp.put(nums[i],value+1);
        }

        for(Map.Entry<Integer,Integer> it:mpp.entrySet())
        {
            if(it.getValue()>(n/2))
                return it.getKey();
        }
        return -1;
    }
}
/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */

//Moore's Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int ans=0,cnt=0;
        for(int i=0;i<n;i++)
        {
            if(cnt==0)
            {
                ans=nums[i];
                cnt++;
            }
            else if(nums[i]==ans){
                cnt++;
            }
            else
            {
                cnt--;
            }
        }
        int cnt1=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==ans) cnt1++;
        }
        if(cnt1>n/2) return ans;

        return -1;
    }
}