https://www.geeksforgeeks.org/problems/minimum-number-in-a-sorted-rotated-array-1587115620/1?page=1&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Array
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            String st[] = read.readLine().trim().split("\\s+");

            int arr[] = new int[n];

            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st[i]);

            System.out.println(new Solution().minNumber(arr,0,n-1));
        }
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        int n=arr.length;
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,arr[i]);
        }
        return mini;
    }
}

//Method-2:

class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        int n=arr.length;


        int mini=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;

            //if left half is sorted
            if(arr[low]<=arr[mid])
            {
                mini=Math.min(mini,arr[low]);

                //Eliminating left half
                low=mid+1;
            }

            else
            { //if right halfis sorted
                mini=Math.min(mini,arr[mid]);

                //Eliminating right half
                high=mid-1;
            }
        }
        return mini;
    }
}

//Method-3 :

class Solution
{
    //Function to find the minimum element in sorted and rotated array.
    static int minNumber(int arr[], int low, int high)
    {
        // Your code here
        int n=arr.length;


        int mini=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if (arr[low] <= arr[high]) {
                mini = Math.min(mini, arr[low]);
                break;
            }

            //if left half is sorted
            if(arr[low]<=arr[mid])
            {
                mini=Math.min(mini,arr[low]);

                //Eliminating left half
                low=mid+1;
            }

            else
            { //if right halfis sorted
                mini=Math.min(mini,arr[mid]);

                //Eliminating right half
                high=mid-1;
            }
        }
        return mini;
    }
}