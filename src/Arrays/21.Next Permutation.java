https://www.geeksforgeeks.org/problems/next-permutation5226/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int idx=-1;

        //step 1:find break point where the value is getting reduced from last
        for(int i=N-2;i>=0;i--)
        {
            if(arr[i]<arr[i+1])
            {
                idx=i;
                break;
            }
        }
        //
        //arr = {1, 2, 3, 6, 5, 4}
        //Output: {1, 2, 4, 3, 5, 6}
        //Step 2: Find the next greater element and swap it with arr[ind]:
        if(idx!=-1)
        {
            for(int i=N-1;i>idx;i--)
            {
                if(arr[i]>arr[idx])
                {
                    swap(arr,i,idx);
                    break;
                }
            }
        }

        //step 3:reverse the right half
        reverse(arr,idx+1);
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            ans.add(arr[i]);
        }
        return ans;
    }
    static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    static void reverse(int[] arr, int start)
    {
        int end=arr.length-1;
        while(start<end)
        {
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}