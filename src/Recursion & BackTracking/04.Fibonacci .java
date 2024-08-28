https://www.geeksforgeeks.org/problems/nth-fibonacci-number1335/1

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends




//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
        // code here
        return check(n);
    }

    static int check(int i)
    {
        if(i<=1) return i;

        int last=check(i-1);
        int sLast=check(i-2);

        return (last+sLast)%1000000007;
    }
}