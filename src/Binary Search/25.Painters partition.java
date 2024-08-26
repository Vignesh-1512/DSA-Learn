https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1?page=1&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    static long minTime(int[] arr,int n,int k){
        //code here
        //Similar to Book Pages allocation problem
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++)
        {
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }

        while(low<=high)
        {
            int mid=(low+high)/2;
            if(countPartition(arr, mid) <= k)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    static int countPartition(int[] arr, int time)
    {
        int n=arr.length;
        int painters=1;
        int boards=0;
        for(int i=0;i<n;i++)
        {
            if(boards+arr[i]<=time)
            {
                //allocate board to current painter
                boards+=arr[i];
            }
            else
            {
                // allocate board to next painter
                painters++;
                boards=arr[i];
            }
        }
        return painters;
    }
}


