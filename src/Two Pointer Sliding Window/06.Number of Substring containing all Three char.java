https://www.geeksforgeeks.org/problems/count-substring/1


//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            //br.readLine();
            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.countSubstring(s);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countSubstring(String s) {
        // code here
        int k=3;
        if (k == 0) return 0; // Edge case: No valid substrings for k = 0

        // Calculate substrings with exactly `k` distinct characters
        return longestkSubStr(s, k) - longestkSubStr(s, k - 1);
    }

    public static int longestkSubStr(String s, int k)
    {
        int n = s.length();
        int l = 0, r = 0, count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        // Traverse the string with two pointers, `l` (left) and `r` (right)
        while (r < n) {
            // Add the character at `r` to the frequency map
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            // If we exceed `k` distinct characters, shrink the window by moving `l`
            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar); // Remove the character if its frequency becomes 0
                }
                l++; // Move the left pointer to reduce distinct characters
            }

            // Count the number of substrings ending at `r` with at most `k` distinct characters
            count += (r - l + 1);

            r++; // Expand the window by moving the right pointer
        }

        return count;
    }
}

