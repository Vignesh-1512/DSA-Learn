https://www.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        int first=-1;
        int last=-1;
        for(int i=0;i<n;i++)
        {
            if(arr[i]==x){
                if(first==-1) first=i;
                last=i;
            }
        }
        if (first != -1) {
            ans.add(first);
            ans.add(last);
        } else {
            ans.add(-1);
            ans.add(-1);
        }
        return ans;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Integer> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends

//Method-2:

class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        // code here
        int fo=findFirst(arr,n,x);
        int lo=findLast(arr,n,x);
        ArrayList<Integer> ans=new ArrayList<>();
        ans.add(fo);
        ans.add(lo);
        return ans;
    }
    int findFirst(int[] arr,int n, int x)
    {
        int fo=-1;
        int low=0;int high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==x)
            {
                fo=mid;
                high=mid-1;
            }
            else if(arr[mid]>x) high=mid-1;
            else low=mid+1;
        }
        return fo;
    }
    int findLast(int[] arr, int n, int x)
    {
        int lo=-1;
        int low=0, high=n-1;
        while(low<=high)
        {
            int mid=(low+high)/2;
            if(arr[mid]==x)
            {
                lo=mid;
                low=mid+1;
            }
            else if(arr[mid]>x) high=mid-1;
            else low=mid+1;
        }
        return lo;
    }
}