https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main (String[] args)throws IOException{

        //taking input using BufferedReader class
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //taking total count of testcases
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            //Reading the two Strings
            String s1 = br.readLine();
            String s2 = br.readLine();

            //Creating an object of class Rotate
            Solution obj = new Solution();

            //calling areRotations method
            //of class Rotate and printing
            //"1" if it returns true
            //else "0"
            if(obj.areRotations(s1,s2))
            {
                System.out.println("1");
            }
            else
            {
                System.out.println("0");
            }
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2 )
    {
        // Your code here
        Queue<Character> q1  = new LinkedList<>();
        for(int i=0; i<s1.length(); i++)
            q1.add(s1.charAt(i));

        Queue<Character> q2  = new LinkedList<>();
        for(int i=0; i<s2.length(); i++)
            q2.add(s2.charAt(i));

        int n = s2.length();
        while(n>0)
        {
            n--;
            char ch = q2.peek();
            q2.remove();
            q2.add(ch);
            if(q1.equals(q2))
                return true;
        }

        return false;
    }

}