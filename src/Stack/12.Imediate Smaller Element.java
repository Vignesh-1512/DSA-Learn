https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1

//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().immediateSmaller(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    void immediateSmaller(int arr[], int n) {
        // code here
        // Stack to keep track of elements
        Stack<Integer> st = new Stack<>();

        // Traverse the array from right to left
        for (int i = n - 1; i >= 0; i--) {
            // If the stack is not empty and the top is smaller than the current element
            int current = arr[i];
            if (!st.isEmpty() && st.peek() < arr[i]) {
                arr[i] = st.peek(); // Update the current element
            } else {
                arr[i] = -1; // No smaller element, set to -1
            }

            // Push the current element to the stack for future comparisons
            st.push(current);
        }
    }
}