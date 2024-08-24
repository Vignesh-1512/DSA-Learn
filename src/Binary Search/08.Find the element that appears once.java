https://www.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array0624/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }

            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        if (n == 1)
            return arr[0];

        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                if(arr[i] != arr[i+1]) return arr[i];
            }
            else if(i==n-1)
            {
                if(arr[i] != arr[i-1]) return arr[i];
            }
            else
            {
                if(arr[i]!=arr[i+1] && arr[i] != arr[i-1]) return arr[i];
            }
        }
        return -1;
    }
}

//Method-2:

class Solution
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans=ans^arr[i];
        }
        return ans;
    }
}

//Methdo-3:

class Solution
{
    int findOnce(int arr[], int n)
    {
        // Complete this function
        //Edge cases
        if(n==1) return arr[0];

        if(arr[0] != arr[1]) return arr[0];

        if(arr[n-1] != arr[n-2]) return arr[n-1];

        int low=1,high=n-2;

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]!= arr[mid+1] && arr[mid] != arr[mid-1])
                return arr[mid];

            //we are in left
            if((mid%2==1 && arr[mid]==arr[mid-1]) || (mid%2==0 && arr[mid]==arr[mid+1]))

                //eliminating left
                low=mid+1;

            else{
                high=mid-1;
            }
        }
        return -1;
    }
}