https://www.geeksforgeeks.org/problems/longest-repeating-character-replacement/1

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            s = s.toUpperCase();
            int ans = obj.characterReplacement(s, k);
            System.out.println(ans);
        }
    }

    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) { in = is; }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan())
                ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char)c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan())
                ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int characterReplacement(String s, int k) {
        // code here
        HashMap<Character, Integer> freq = new HashMap<>();
        int l = 0, maxFreq = 0, maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char rightChar = s.charAt(r);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);

            // Update the max frequency of any single character in the current window
            maxFreq = Math.max(maxFreq, freq.get(rightChar));

            // If the window is invalid (i.e., replacements needed exceed k), shrink the window
            while ((r - l + 1) - maxFreq > k) {
                char leftChar = s.charAt(l);
                freq.put(leftChar, freq.get(leftChar) - 1);
                l++; // Move the left pointer to reduce the window size
            }

            // Update the maximum length of valid windows found so far
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;

    }
}
