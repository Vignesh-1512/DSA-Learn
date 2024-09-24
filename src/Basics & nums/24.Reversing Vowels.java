https://www.geeksforgeeks.org/problems/reversing-the-vowels5304/1

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
            String s;
            s = sc.next();

            Solution ob = new Solution();

            System.out.println(ob.modify(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String modify (String s)
    {
        // your code here
        String vowels="aeiouAEIOU";
        StringBuilder res= new StringBuilder(s);
        int start=0;
        int end=s.length()-1;
        while(start<end){
            while(start<end && vowels.indexOf(s.charAt(start))==-1){
                start++;
            }
            while(start<end && vowels.indexOf(s.charAt(end))==-1){
                end--;
            }


            if(start<end){
                res.setCharAt(start,s.charAt(end));
                res.setCharAt(end,s.charAt(start));
                start++;
                end--;
            }
        }
        return res.toString();
    }
}
