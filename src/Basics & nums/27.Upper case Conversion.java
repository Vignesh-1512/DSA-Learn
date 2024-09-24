https://www.geeksforgeeks.org/problems/upper-case-conversion5419/1

//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t-->0)
        {
            String str = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.transform(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String transform(String s)
    {
        // code here
        String[] words=s.split(" ");
        String result="";
        for(String word:words){
            if(word.length()>0){
                result+= Character.toUpperCase(word.charAt(0))+
                        word.substring(1)+" ";
            }
        }
        return result.trim();
    }
}