https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=row-with-max-1s

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n=arr.length;
        int m=arr[0].length;
        int index=-1;
        int cntMax=0;
        for(int i=0;i<n;i++)
        {
            int cntOnes=m-lowerBound(arr[i],m,1);
            if(cntOnes>cntMax)
            {
                cntMax=cntOnes;
                index=i;
            }
        }
        return index;
    }

    public int lowerBound(int arr[], int n, int x)
    {
        int low=0;
        int high=n-1;
        int ans=n;
        while(low<=high)
        {
            int mid=(low+high)/2;

            if(arr[mid]>=x)
            {
                ans=mid;
                high=mid-1;
            }
            else low=mid+1;
        }
        return ans;
    }
}