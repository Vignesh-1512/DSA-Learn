https://www.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1?page=1&category=Stack&sortBy=submissions

//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            String inputLine[] = br.readLine().trim().split(" ");
            long[] arr = new long[(int)n];
            for (int i = 0; i < n; i++) arr[i] = Long.parseLong(inputLine[i]);
            System.out.println(new Solution().getMaxArea(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[]) {
        // Length of the histogram
        long n = hist.length;

        // Find nearest smaller elements to the left and right
        long[] nseli = left(hist, n);
        long[] nseri = right(hist, n);

        // Variable to store the maximum area
        long maxArea = 0L;

        // Calculate the area for each histogram bar
        for (long i = 0; i < n; i++) {
            // Calculate area with current histogram bar as the smallest height
            long area = (nseri[(int)i] - nseli[(int)i] - 1) * hist[(int)i];
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    public static long[] left(long hist[], long n) {
        long[] nseli = new long[(int)n];
        Stack<Long> st = new Stack<>();

        // Traverse the histogram from left to right
        for (long i = 0; i < n; i++) {
            // Pop from stack until we find a smaller element
            while (!st.isEmpty() && hist[st.peek().intValue()] >= hist[(int)i]) {
                st.pop();
            }

            // If the stack is empty, there is no smaller element to the left
            if (!st.isEmpty()) {
                nseli[(int)i] = st.peek();
            } else {
                nseli[(int)i] = -1;
            }

            // Push the current index onto the stack
            st.push(i);
        }
        return nseli;
    }

    public static long[] right(long hist[], long n) {
        long[] nseri = new long[(int)n];
        Stack<Long> st = new Stack<>();

        // Traverse the histogram from right to left
        for (long i = n - 1; i >= 0; i--) {
            // Pop from stack until we find a smaller element
            while (!st.isEmpty() && hist[st.peek().intValue()] >= hist[(int)i]) {
                st.pop();
            }

            // If the stack is empty, there is no smaller element to the right
            if (!st.isEmpty()) {
                nseri[(int)i] = st.peek();
            } else {
                nseri[(int)i] = n;
            }

            // Push the current index onto the stack
            st.push(i);
        }
        return nseri;
    }
}
