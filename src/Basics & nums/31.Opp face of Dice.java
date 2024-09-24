https://www.geeksforgeeks.org/problems/the-dice-problem2316/0

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();


            Solution ob = new Solution();
            int ans  = ob.oppositeFaceOfDice(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int oppositeFaceOfDice(int N){
        // code here
        int diff=6-N;
        int start = 1+diff;
        return start;
    }
}