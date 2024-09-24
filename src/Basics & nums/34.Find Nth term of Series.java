https://www.geeksforgeeks.org/problems/find-n-th-term-of-series-1-3-6-10-15-215506/1

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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findNthTerm(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findNthTerm(int N) {
        // code here
        int num=0;
        for(int i=1;i<=N;i++){
            num=num+i;
        }
        return num;
    }
}