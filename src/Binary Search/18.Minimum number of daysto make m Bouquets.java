https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val=(long)m*k;
        int n=bloomDay.length;

        if(val > n) return -1;

        //To find min and max value in array
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }

        for(int i=mini;i<=maxi;i++)
        {
            if(possible(bloomDay, i, m, k))
                return i;
        }
        return -1;
    }

    public boolean possible(int[] bloomDay, int day, int m, int k)
    {
        int n=bloomDay.length;
        int cnt=0;
        int noOfB=0;

        // Count the number of bouquets:
        for(int i=0;i<n;i++)
        {
            if(bloomDay[i]<=day)
                cnt++;
            else{
                noOfB+=(cnt/k);
                cnt=0;
            }
        }
        noOfB+=(cnt/k);
        return noOfB >=m;
    }
}

//Optimal::

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val=(long)m*k;
        int n=bloomDay.length;

        if(val > n) return -1;

        //To find min and max value in array
        int mini=Integer.MAX_VALUE;
        int maxi=Integer.MIN_VALUE;

        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,bloomDay[i]);
            maxi=Math.max(maxi,bloomDay[i]);
        }
        //using binary search:
        int low=mini, high=maxi;

        while(low<=high)
        {
            int mid=(low+high)/2;
            if(possible(bloomDay, mid, m ,k))
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    public boolean possible(int[] bloomDay, int day, int m, int k)
    {
        int n=bloomDay.length;
        int cnt=0;
        int noOfB=0;

        // Count the number of bouquets:
        for(int i=0;i<n;i++)
        {
            if(bloomDay[i]<=day)
                cnt++;
            else{
                noOfB+=(cnt/k);
                cnt=0;
            }
        }
        noOfB+=(cnt/k);
        return noOfB >=m;
    }
}