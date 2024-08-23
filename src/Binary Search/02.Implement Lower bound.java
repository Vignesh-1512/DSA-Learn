https://www.naukri.com/code360/problems/lower-bound_8165382?leftPanelTabValue=SUBMISSION

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binarysearch(arr, k);
            System.out.println(res);
        }
        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid] == k) return mid;
            else if(k > arr[mid]) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
}

//Method-2:

class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int n=arr.length;
        return search(arr,0,n-1,k);
    }
    public int search(int[] arr, int low, int high, int k)
    {
        if(low>high) return -1;

        int mid=(low+high)/2;
        if(arr[mid] == k) return mid;
        else if(k > arr[mid])
            return search(arr, mid+1,high,k);


        return search(arr,low,mid-1,k);
    }
}