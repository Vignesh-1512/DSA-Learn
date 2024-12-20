package Sorting;

https://www.geeksforgeeks.org/problems/merge-sort/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//    Given an array arr[], its starting position l and its ending position r. Sort the array using merge sort algorithm.
//        Example 1:
//
//        Input:
//        N = 5
//        arr[] = {4 1 3 9 7}
//        Output:
//        1 3 4 7 9


//Merge sort involves dividing the array into two parts and sorting them and merging later
//TC: O(N log2N) -> best, average, worst
//SC: O(N) -> as we create a temp arraylist in merge fn..

//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
    static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }



    public static void main(String args[])
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        //taking testcases
        int T = sc.nextInt();
        while(T>0)
        {
            //taking elements count
            int n = sc.nextInt();

            //creating an object of class Merge_Sort
            Merge_Sort ms = new Merge_Sort();

            //creating an array of size n
            int arr[] = new int[n];

            //adding elements to the array
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();


            Solution g = new Solution();

            //calling the method mergeSort
            g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
            ms.printArray(arr);
            T--;
        }
    }
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int low, int mid, int high)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int left = low;
        int right = mid+1;
        while(left<=mid && right<=high)
        {
            if(arr[left]<=arr[right])
            {
                ans.add(arr[left]);
                left++;
            }
            else
            {
                ans.add(arr[right]);
                right++;
            }
        }
        while(left<=mid)
        {
            ans.add(arr[left]);
            left++;
        }
        while(right<=high)
        {
            ans.add(arr[right]);
            right++;

        }

        // Copy the sorted elements back to the original array
        for(int j=low; j<=high; j++)
            arr[j]=ans.get(j-low);
    }
    void mergeSort(int arr[], int low, int high)
    {
        //code here
        if(low>=high)   return;
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
}