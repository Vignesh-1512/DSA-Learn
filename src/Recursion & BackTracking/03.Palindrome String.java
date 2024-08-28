https://www.geeksforgeeks.org/problems/palindrome-string0817/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String S) {
        // code here
        int n=S.length();
        return check(S,0,n-1);
    }

    int check(String s, int st, int ed)
    {

        if(st >= ed)  return 1;

        if(s.charAt(st)!=s.charAt(ed))    return 0;

        return check(s,st+1,ed-1);
    }
};