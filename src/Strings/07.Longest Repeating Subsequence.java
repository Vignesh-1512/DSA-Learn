https://www.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

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
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        return solve(str,str.length(),str.length());
    }
    public int solve(String str,int n,int m){
        if(n==0 || m==0) return 0;
        if(str.charAt(n-1)==str.charAt(m-1) && n!=m)
            return 1+solve(str, n-1, m-1);
        return Math.max(solve(str, n, m-1), solve(str, n-1, m));
    }
}