https://www.geeksforgeeks.org/problems/print-pattern3549/1?page=1&category=Recursion&difficulty=Easy&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());

            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.pattern(N);
            for(int i = 0;i < ans.size();i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public List<Integer> pattern(int N){
        // code here

        List<Integer> result=new ArrayList<Integer>();
        generatepattern(N,N,result,false);
        return result;
    }

    public void generatepattern(int curr, int original, List<Integer> result, boolean increasing)
    {
        result.add(curr);

        if(curr==original&&increasing)
        {
            return;
        }
        if(curr<=0)
        {
            increasing=true;
        }

        if(!increasing)
        {
            generatepattern(curr-5,original,result,increasing);
        }
        else
        {
            generatepattern(curr+5,original,result,increasing);
        }
    }
}