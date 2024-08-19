https://leetcode.com/problems/rearrange-array-elements-by-sign/

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0) pos.add(nums[i]);
            else neg.add(nums[i]);
        }
        for(int i=0;i<n/2;i++)
        {
            nums[2*i]=pos.get(i);
            nums[2*i+1]=neg.get(i);
        }
        return nums;
    }
}

/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        int pos=0;
        int neg=1;
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0)
            {
                ans[pos]=nums[i];
                pos+=2;
            }
            else
            {
                ans[neg]=nums[i];
                neg+=2;
            }
        }
        return ans;
    }
}
/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */