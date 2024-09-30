https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        int i=0;
        Stack<String> st=new Stack<>();

        while(i<post_exp.length())
        {
            char c=post_exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                st.push(String.valueOf(c));
            }
            else
            {
                String operand1=st.pop();
                String operand2=st.pop();
                String preFix=c + operand2 + operand1;
                st.push(preFix);
            }
            i++;
        }
        return st.pop();
    }
}
