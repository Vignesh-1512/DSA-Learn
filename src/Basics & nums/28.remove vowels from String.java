https://www.geeksforgeeks.org/problems/remove-vowels-from-string1446/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeVowels(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeVowels(String S) {
        // code here
        StringBuilder sb=new StringBuilder();
        //String str=new String();
        for(char ch: S.toCharArray()){
            if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u' &&
                    ch!='A' && ch!='E' && ch!='I' && ch!='O' && ch!='U'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}