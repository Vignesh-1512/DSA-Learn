https://leetcode.com/problems/koko-eating-bananas/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxi=findMax(piles);
        //Concept is she can eat bananas from 1 to max ele in array per hour
        //Find the minimum value of k:
        for(int i=1;i<=maxi;i++)
        {
            int reqTime=CalculateTime(piles, i);
            if(reqTime<=h)
                return i;
        }
        return maxi;
    }

    public int findMax(int[] piles)
    {
        int n=piles.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }

    //hourly->number of banana KoKo can eat per hour
    public int CalculateTime(int[] piles, int hourly)
    {
        int totalH=0;
        int n=piles.length;
        for(int i=0;i<n;i++)
        {
            totalH+=Math.ceil((double)(piles[i])/(double)(hourly));
        }
        return totalH;
    }
}

//OPTIMAL::

class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        //Concept is she can eat bananas from 1 to max ele in array per hour
        int low=1, high=findMax(piles);
        while(low<=high)
        {
            int mid=(low+high)/2;

            int totalH=CalculateTime(piles, mid);

            if(totalH <= h)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }

    public int findMax(int[] piles)
    {
        int n=piles.length;
        int maxi=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,piles[i]);
        }
        return maxi;
    }

    //hourly->number of banana KoKo can eat per hour
    public int CalculateTime(int[] piles, int hourly)
    {
        int totalH=0;
        int n=piles.length;
        for(int i=0;i<n;i++)
        {
            totalH+=Math.ceil((double)(piles[i])/(double)(hourly));
        }
        return totalH;
    }
}