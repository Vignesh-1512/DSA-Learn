https://www.geeksforgeeks.org/problems/selection-sort/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            obj.selectionSort(arr, n);

            for(int i=0;i<n;i++)
                System.out.print(arr[i]+" ");
            System.out.println();
            t--;
        }

    }
}

// } Driver Code Ends


class Solution
{


    //taking minimum element and swap to first

    void selectionSort(int arr[], int n)
    {
        //code here
        for(int i=0;i<n-1;i++){
            int minIndex=i;
            for(int j=i;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[minIndex];
            arr[minIndex]=temp;

        }

    }
}