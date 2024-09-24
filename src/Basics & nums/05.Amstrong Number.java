https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    static int countDigits(int n)
    {
        int ct = 0;
        while(n>0)
        {
            ct++;
            n=n/10;
        }
        return ct;
    }

    static String armstrongNumber(int n) {
        // code here
        int digits = countDigits(n);
        int temp = n;
        int sum = 0;
        while(temp>0)
        {
            int last = temp%10;
            sum = sum + (int) Math.pow(last,digits);
            temp = temp/10;
        }
        if(sum==n)
            return "true";
        else
            return "false";
    }
}