            ASCII values  of alphabets: A – Z = 65 to 90, a – z = 97 to 122

https://www.geeksforgeeks.org/problems/lower-case-to-upper-case3410/1

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GFG{
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String str = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.to_upper(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    String to_upper(String str)
    {
        // code here
        String res=str.toUpperCase();
        return res;
    }
}

//Method-2:

