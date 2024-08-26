https://www.geeksforgeeks.org/problems/split-array-largest-sum--141634/1?page=2&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String St[] = read.readLine().split(" ");

            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);

            String S[] = read.readLine().split(" ");

            int[] arr = new int[N];

            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        //Similar to Book Pages allocation problem
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<N;i++)
        {
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }

        while(low<=high)
        {
            int mid=(low+high)/2;
            if(countPartition(arr, mid)<=K)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    static int countPartition(int[] arr, int maxSum)
    {
        int n=arr.length;
        int partition=1;
        int subArrSum=0;

        for(int i=0;i<n;i++)
        {
            if(subArrSum+arr[i]<=maxSum)
            {
                //insert element to current subarray
                subArrSum+=arr[i];
            }
            else
            {
                partition++;
                subArrSum=arr[i];
            }
        }
        return partition;
    }
};