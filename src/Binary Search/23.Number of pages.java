https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.findPages(n, a, m));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find minimum number of pages.
    public static long findPages(int n, int[] arr, int m) {
        // Your code here

        if(m>n) return -1; // Not enough books for students.

        int low=Integer.MIN_VALUE;
        int high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,arr[i]);
            high+=arr[i];
        }
        while(low<=high)
        {
            int mid=(low+high)/2;

            if(countStudents(arr, mid)<=m)
                // If it is possible to allocate with current mid as the max, try for a smaller value.
                high=mid-1;
            else
                // If not possible, try for a larger value.
                low=mid+1;
        }
        return low;
    }


    public static int countStudents(int[] arr, int pages)
    {
        int n=arr.length;
        int student=1;
        int pagesStudent=0;
        for(int i=0;i<n;i++)
        {
            if(pagesStudent+arr[i]<=pages)
            {
                // Continue allocating books to the current student.
                pagesStudent+=arr[i];
            }
            else{
                // Allocate the current book to the next student.
                student++;
                pagesStudent=arr[i];
            }
        }
        return student;
    }
};