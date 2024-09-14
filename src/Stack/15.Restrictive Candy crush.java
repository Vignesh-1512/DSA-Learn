https://www.geeksforgeeks.org/problems/restrictive-candy-crush--141631/1?page=2&category=Stack&sortBy=submissions

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.math.*;
import java.io.*;

class FastReader{
    BufferedReader br;
    StringTokenizer st;

    public FastReader(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next(){
        while (st == null || !st.hasMoreElements()){
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); }
        }
        return st.nextToken();
    }

    String nextLine(){
        String str = "";
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); }
        return str;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            out.println(T.reduced_String(k, s));
        }
        out.flush();
    }
}

// } Driver Code Ends


//User function Template for Java

/*
    Note: Use StringBuilder/StringBuffer class for String concatenation(if any).
    While using String class, on each concatenation a new copy of the string is created, so that
    the overall complexity is O(n^2) . Fortunately in Java we could solve this with a StringBuffer/StringBuffer,
    which has O(1) complexity for each append.
*/

class Solution
{
    public static String reduced_String(int k, String s)
    {
        // Your code goes here
        // Edge case: if k == 1, the entire string will be removed.
        if (k == 1) {
            return "";
        }

        // Stack to store pairs of (character, frequency)
        Stack<Pair> stack = new Stack<>();

        // Traverse the string
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == c) {
                // Increment the frequency of the character at the top of the stack
                stack.peek().freq++;

                // If the frequency equals k, remove the character from the stack
                if (stack.peek().freq == k) {
                    stack.pop();
                }
            } else {
                // Push the character with a frequency of 1
                stack.push(new Pair(c, 1));
            }
        }

        // Build the reduced string from the stack
        StringBuilder result = new StringBuilder();
        for (Pair p : stack) {
            for (int i = 0; i < p.freq; i++) {
                result.append(p.ch);
            }
        }

        return result.toString();
    }

    // Helper class to store character and its frequency
    static class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

}