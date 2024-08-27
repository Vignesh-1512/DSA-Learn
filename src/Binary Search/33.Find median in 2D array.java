https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

//Brutte Force:

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<R;i++)
        {
            for(int j=0;j<C;j++)
            {
                ans.add(matrix[i][j]);
            }
        }
        Collections.sort(ans);
        return ans.get((R*C)/2);
    }
}

//Optimal :

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
        import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int median(int matrix[][], int R, int C) {
        // code here
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i=0; i<R; i++)
        {
            low = Math.min(low,matrix[i][0]);
            high = Math.max(high,matrix[i][C-1]);
        }
        int req = (R*C)/2;
        while(low<=high)
        {
            int mid = (low+high)/2;
            int smallEqual = countSmallEqual(matrix,mid,R,C);
            if(smallEqual<=req)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
    int countSmallEqual(int[][]arr, int x, int n, int m)
    {
        int ct = 0;
        for(int i=0; i<n; i++)
            ct += upperBound(arr[i],x,m);
        return ct;
    }
    int upperBound(int[]arr, int x, int m)
    {
        int low =0; int high =m-1;
        int ans = m;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(arr[mid]>x)
            {
                ans = mid;
                high = mid-1;
            }else
                low = mid+1;
        }
        return ans;

    }
}