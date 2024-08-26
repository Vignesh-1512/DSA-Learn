https://www.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1?page=2&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];

            int D = Integer.parseInt(read.readLine());

            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr, N, D));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here
        int maxi=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            maxi=Math.max(maxi,arr[i]);
        }

        for(int i=maxi;i<=sum;i++)
        {
            if(findDays(arr, i) <= d) return i;
        }
        return -1;
    }

    static int findDays(int[] arr, int cap)
    {
        int n=arr.length;
        int day=1;//first day
        int load=0;
        for(int i=0;i<n;i++)
        {
            if(load+arr[i]>cap)
            {
                day++;  //Move to next day
                load=arr[i]; //Load the weight
            }
            else
            {
                load+=arr[i];
            }
        }
        return day;
    }
};

//Method-2:

class Solution {
    static int leastWeightCapacity(int[] arr, int n, int d) {
        // code here
        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++)
        {
            high+=arr[i];
            low=Math.max(low,arr[i]);
        }

        while(low<=high)
        {
            int mid=(low+high)/2;

            if(findDays(arr, mid)<=d)
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }

    static int findDays(int[] arr, int cap)
    {
        int n=arr.length;
        int day=1;//first day
        int load=0;
        for(int i=0;i<n;i++)
        {
            if(load+arr[i]>cap)
            {
                day++;  //Move to next day
                load=arr[i]; //Load the weight
            }
            else
            {
                load+=arr[i];
            }
        }
        return day;
    }
};