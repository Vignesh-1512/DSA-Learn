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

//Method-2:

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        if(n > threshold) return -1;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,nums[i]);
        }

        int low=1, high=maxi;
        while(low<=high)
        {
            int mid=(low+high)/2;

            if(sumByD(nums,mid)<=threshold){
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;

    }

    public int sumByD(int[] nums, int mid)
    {
        int n=nums.length;
        //Find the smallest divisor:
        //To find summation of divisor
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=Math.ceil((double)nums[i]/(double)mid);
        }
        return sum;
    }
}