https://www.geeksforgeeks.org/problems/ncr1019/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String read[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(read[0]);
            int r = Integer.parseInt(read[1]);

            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.

//nCr = n! / (r! * (n-r)!)

// Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

// Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

// In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:

class Solution{
    static int nCr(int n, int r)
    {
        // code here
        long res=1;
        for(int i=0;i<r;i++)
        {
            res=res*(n-i);
            res= res/(i+1);
        }
        return (int) res;
    }
}