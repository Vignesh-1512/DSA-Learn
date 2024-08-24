https://www.geeksforgeeks.org/problems/rotation4723/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }
            Solution ob = new Solution();
            int res = ob.findKRotation(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int n=arr.size();
        int mini=Integer.MAX_VALUE;
        int ans=-1; //return -1 if array is empty
        for(int i=0;i<n;i++)
        {
            if(arr.get(i) < mini){
                mini=arr.get(i);
                ans=i;
            }
        }
        return ans;
    }
}

//Method-2:

class Solution {
    public int findKRotation(List<Integer> arr) {
        // Code here
        int n=arr.size();
        int low=0,high=n-1;
        int ans=-1;
        int mini=Integer.MAX_VALUE;

        while(low<=high)
        {
            int mid=(low+high)/2;

            //search space is already sorted
            //then arr[low] will always be
            //the minimum in that search space:
            if(arr.get(low)<=arr.get(high))
            {
                if(arr.get(low)<mini)
                {
                    ans=low;
                    mini=arr.get(low);
                }
                break;
            }

            //if left part is sorted
            if(arr.get(low)<=arr.get(mid))
            {
                if(arr.get(low)<mini)
                {
                    ans=low;
                    mini=arr.get(low);
                }

                //Eliminating left part:
                low=mid+1;
            }
            else
            { //if right part is sorted
                if(arr.get(mid)<mini)
                {
                    ans=mid;
                    mini=arr.get(mid);
                }

                //Eliminating right part
                high=mid-1;
            }

        }
        return ans;
    }
}