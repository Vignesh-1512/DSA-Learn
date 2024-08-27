https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=k-th-element-of-two-sorted-array

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int a[], int b[]) {
        // code here
        int n1=a.length;
        int n2=b.length;
        if(n1>n2) kthElement(k, b, a);

        int left=k; //length of left half

        // apply binary search:
        int low = Math.max(k-n2,0);
        int high = Math.min(k,n1); //take the length of mini array as HIGH
        while(low<=high)
        {
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if(mid1<n1)      r1=a[mid1];
            if(mid2<n2)      r2=b[mid2];
            if(mid1-1>=0)   l1=a[mid1-1];
            if(mid2-1>=0)   l2=b[mid2-1];

            if(l1<=r2 && l2<=r1)
            {
                return (long)Math.max(l2,l1);
            }else if(l1>r2) high = mid1-1;
            else low = mid1+1;
        }
        return 0;

    }
}