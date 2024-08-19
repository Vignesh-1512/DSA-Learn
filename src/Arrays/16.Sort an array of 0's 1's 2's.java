https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for Java

class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here
        int count0=0;int count1=0; int count2=0;
        for(int i=0;i<n;i++){
            if(a[i]==0) count0++;
            else if(a[i]==1)  count1++;
            else  count2++;
        }
        for(int i=0;i<count0;i++) a[i]=0;
        for(int i=count0;i<count0+count1;i++) a[i]=1;
        for(int i=count0+count1;i<n;i++) a[i]=2;
    }
}

//{ Driver Code Starts.

class GFG {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
        while(t-->0){
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob=new Solution();
            ob.sort012(arr, n);
            StringBuffer str = new StringBuffer();
            for(int i=0; i<n; i++){
                str.append(arr[i]+" ");
            }
            System.out.println(str);
        }
    }
}


// } Driver Code Ends

/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
 */

//Just counting no.of 0,1,2 and printing them also works, but TC: O(2N)

//This problem is a variation of the popular Dutch National flag algorithm.

// This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:

// arr[0….low-1] contains 0. [Extreme left part]
// arr[low….mid-1] contains 1.
// arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array
class Solution
{
    public static void sort012(int a[], int n)
    {
        // code here
        int low=0;int mid=0; int high=n-1;
        while(mid<=high){
            if(a[mid]==0)
            {
                int temp=a[low];
                a[low]=a[mid];
                a[mid]=temp;
                low++;
                mid++;
            }
            else if(a[mid]==1)
            {
                mid++;
            }
            else
            {
                int temp=a[mid];
                a[mid]=a[high];
                a[high]=temp;
                high--;
            }
        }
    }

    public static void swap(int a[],int i,int j)
    {
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}