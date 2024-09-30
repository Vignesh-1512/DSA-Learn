https://www.geeksforgeeks.org/problems/prefix-to-infix-conversion/1

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
            String ans = obj.preToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    static String preToInfix(String pre_exp) {
        // code here
        int i=pre_exp.length()-1;
        Stack<String> st=new Stack<>();
        while(i>=0)
        {
            char c=pre_exp.charAt(i);
            if(Character.isLetterOrDigit(c))
            {
                st.push(String.valueOf(c));
            }
            else
            {
                String operand1=st.pop();
                String operand2=st.pop();
                String inFix="(" + operand1 + c + operand2 + ")";
                st.push(inFix);
            }
            i--;
        }
        return st.pop();
    }
}
