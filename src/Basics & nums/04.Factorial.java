https://www.geeksforgeeks.org/problems/factorial5739/1


//{ Driver Code Starts
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
            System.out.println(ob.factorial(N));
        }
    }
}
// } Driver Code Ends


class Solution{
    static long factorial(int N){
        // code here
        if(N<=1) return 1;
        return N*factorial(N-1);
    }
}



class Solution{
    static long factorial(int N){
        // code here
        long res = 1;
        for(int i=2; i<=N; i++)
        {
            res *= i;
        }
        return res;
    }
}