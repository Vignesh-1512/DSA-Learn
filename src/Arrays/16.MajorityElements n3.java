https://leetcode.com/problems/majority-element-ii/



class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> ls=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(ls.size()==0||ls.get(0) != nums[i])
            {
                int cnt=0;
                for(int j=0;j<n;j++)
                {
                    if(nums[i]==nums[j])
                        cnt++;
                }
                if(cnt>n/3)
                {
                    ls.add(nums[i]);
                }
            }
            if(ls.size()==2) break;
        }
        return ls;
    }
}

//Method-2:

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        List<Integer> ls=new ArrayList<>();

        Map<Integer,Integer> mpp=new HashMap<>();

        int min=(int) (n/3)+1;
        for(int i=0; i<n; i++)
        {
            int value=mpp.getOrDefault(nums[i],0);
            mpp.put(nums[i],value+1);

            if(mpp.get(nums[i])==min)
                ls.add(nums[i]);
            if(ls.size()==2) break;
        }
        return ls;
    }
}

//Method-3:

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int cnt1=0, cnt2=0;
        int el1=Integer.MIN_VALUE;
        int el2=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            if(cnt1==0 && el2!=nums[i])
            {
                cnt1=1;
                el1=nums[i];
            }
            else if(cnt2==0 && el1!=nums[i])
            {
                cnt2=1;
                el2=nums[i];
            }
            else if(nums[i]==el1) cnt1++;
            else if(nums[i]==el2) cnt2++;
            else{
                cnt1--;cnt2--;
            }
        }

        List<Integer> ls=new ArrayList<>(); //list of answer

        // Manually check if the stored elements in
        // el1 and el2 are the majority elements:
        cnt1=0;cnt2=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==el1) cnt1++;
            if(nums[i]==el2) cnt2++;
        }

        int min=(int) (n/3)+1;
        if(cnt1>=min) ls.add(el1);
        if(cnt2>=min) ls.add(el2);
        Collections.sort(ls);
        return ls;
    }
}
