https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                    new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends




class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String exp) {
        // Your code here

        Stack<Character> st=new Stack<>();
        StringBuilder res=new StringBuilder();
        for (int i=0;i<exp.length();i++)
        {
            char c= exp.charAt(i);


            if(Character.isLetterOrDigit(c))
            {
                res.append(c);
            }

            else if(c=='(')
            {
                st.push(c);
            }

            else if(c==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    res.append(st.pop());
                }
                st.pop();
            }

            else {
                while (!st.isEmpty() && precedence(c) <= precedence(st.peek())) {
                    res.append(st.pop());
                }
                st.push(c);
            }
        }
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }
    public static int precedence(char ch)
    {
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }


}