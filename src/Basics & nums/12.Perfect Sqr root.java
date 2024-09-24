https://www.geeksforgeeks.org/problems/check-perfect-square5253/1

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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.checkPerfectSquare(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static int checkPerfectSquare(int N){
        // code here
        long low = 1; long high = N;
        while (low <= high)
        {
            long mid = (low + high) / 2;
            if (mid * mid == N)
                return 1;
            else if (mid * mid < N)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return 0;
    }
}