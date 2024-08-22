https://leetcode.com/problems/3sum/



class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
        Set<List<Integer>> st=new HashSet<>();

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        List<Integer> temp=Arrays.asList(nums[i],nums[j],nums[k]);
                        Collections.sort(temp);
                        st.add(temp);
                    }
                }
            }
        }
        return new ArrayList<> (st);
    }
}

//Method-2:

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum<0)
                {
                    j++;
                }
                else if(sum>0)
                {
                    k--;
                }
                else
                {
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);
                    ans.add(list);
                    j++;k--;
                    while(j<k && nums[j]==nums[j-1])    j++;
                    while(j<k && nums[k]==nums[k+1])    k--;
                }
            }
        }
        return ans;
    }
}


