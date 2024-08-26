https://www.geeksforgeeks.org/problems/aggressive-cows/1?page=1&category=Binary%20Search&sortBy=submissions

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);

        int limit=stalls[n-1]-stalls[0];
        for(int i=1;i<=limit;i++)
        {
            if(canWePlace(stalls, i, k)==true)
                continue;
            else return(i-1);
        }


        return limit;
    }

    public static boolean canWePlace(int[] stalls, int dist, int k)
    {
        int n=stalls.length;
        int cntcows=1;
        int last=stalls[0];
        for(int i=1;i<n;i++)
        {
            if(stalls[i]-last >= dist)
            {
                cntcows++; //place next cow.
                last=stalls[i]; //update the last location.
            }
            if(cntcows>=k) return true;
        }
        return false;
    }
}

//Method-2:

class Solution {
    public static int solve(int n, int k, int[] stalls) {
        Arrays.sort(stalls);

        int low=1, high=stalls[n-1]-stalls[0];
        while(low<=high)
        {
            int mid=low+high/2;
            if(canWePlace(stalls, mid, k)==true)
                low=mid+1;
            else high=mid-1;
        }


        return high;
    }

    public static boolean canWePlace(int[] stalls, int dist, int k)
    {
        int n=stalls.length;
        int cntcows=1;
        int last=stalls[0];
        for(int i=1;i<n;i++)
        {
            if(stalls[i]-last >= dist)
            {
                cntcows++; //place next cow.
                last=stalls[i]; //update the last location.
            }
            if(cntcows>=k) return true;
        }
        return false;
    }
}