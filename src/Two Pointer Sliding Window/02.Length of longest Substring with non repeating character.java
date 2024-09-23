https://www.geeksforgeeks.org/problems/length-of-the-longest-substring3036/1

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
            String s = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubsttr(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    int longestUniqueSubsttr(String S){
        HashMap<Character, Integer> map=new HashMap<>();

        int l=0, r=0;
        int n=S.length();
        int len=0;
        while(r<n)
        {
            if(map.containsKey(S.charAt(r)))
                l=Math.max(map.get(S.charAt(r)) + 1, l);
            map.put(S.charAt(r),r);

            len = Math.max(len, r - l + 1);
            r++;
        }
        return len;
    }
}