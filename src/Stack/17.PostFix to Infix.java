https://www.geeksforgeeks.org/problems/postfix-to-infix-conversion/1

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
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here

        Stack<String> st=new Stack<>();
        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                st.push(String.valueOf(c));
            }
            // If the character is an operator, pop two elements from the stack,
            // combine them with the operator, and push the result back to the stack
            else {
                String operand2 = st.pop();
                String operand1 = st.pop();
                String infix = "(" + operand1 + c + operand2 + ")";
                st.push(infix);
            }
        }
        return st.pop();
    }
}
