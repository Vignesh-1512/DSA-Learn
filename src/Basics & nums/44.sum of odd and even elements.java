https://www.geeksforgeeks.org/problems/sum-of-odd-and-even-elements3033/0

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.find_sum(n);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] find_sum(int n)
    {
        // Code here
        int odd=0,even=0;
        for(int i=1;i<=n;i+=2){
            odd+=i;
        }
        for(int i=2;i<=n;i+=2){
            even+=i;
        }
        return new int[]{odd,even};
    }
}