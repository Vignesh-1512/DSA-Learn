https://www.geeksforgeeks.org/problems/minimum-window-subsequence/0

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
            String s1 = sc.next();
            String s2 = sc.next();
            Solution obj = new Solution();
            String ans = obj.minWindow(s1, s2);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String minWindow(String str1, String str2) {
        // code here
        int n = str1.length();
        int m = str2.length();
        String result = "";
        int minLen = Integer.MAX_VALUE;

        for (int left = 0; left < n; left++) {
            int right = left;
            int str2Index = 0;

            while (right < n && str2Index < m) {
                if (str1.charAt(right) == str2.charAt(str2Index)) {
                    str2Index++;
                }
                right++;
            }

            // If we have found the whole str2 in str1
            if (str2Index == m) {
                // Backtrack to find the actual end of the window
                int end = right - 1;
                str2Index = m - 1;

                while (end >= left && str2Index >= 0) {
                    if (str1.charAt(end) == str2.charAt(str2Index)) {
                        str2Index--;
                    }
                    end--;
                }

                // Adjust end to include the last matched character
                end++;

                // Update result if the current window is smaller
                if (end - left < minLen) {
                    minLen = end - left;
                    result = str1.substring(left, right);
                }
            }
        }

        return result;
    }
}
