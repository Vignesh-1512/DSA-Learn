https://www.geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s[] = read.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            int A[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String S[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    A[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.minRow(N, M, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int minRow(int n, int m, int a[][]) {
        // code here
        int index = 1; // To track the row with minimum 1s
        int minCount = Integer.MAX_VALUE; // Initialize to max value

        for (int i = 0; i < n; i++) {
            // Count number of 1's in the current row
            int countOnes = m - lowerBound(a[i], m, 1);
            // Update index if the current row has fewer 1's
            if (countOnes < minCount) {
                minCount = countOnes;
                index = i;
            }
        }
        return index; // Return the index of the row with minimum 1's
    }

    public int lowerBound(int arr[], int n, int x) {
        int low = 0;
        int high = n - 1;
        int ans = n;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                ans = mid; // Update the position of the first occurrence of x
                high = mid - 1; // Search in the left half
            } else {
                low = mid + 1; // Search in the right half
            }
        }
        return ans; // Return the index of the first occurrence
    }

};