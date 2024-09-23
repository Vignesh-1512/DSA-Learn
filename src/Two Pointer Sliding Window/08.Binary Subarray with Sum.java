https://www.geeksforgeeks.org/problems/binary-subarray-with-sum/0

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character after reading the integer

        while (t-- > 0) {
            String input = sc.nextLine();
            String[] inputArray = input.split(" ");
            int[] arr = new int[inputArray.length];

            for (int i = 0; i < inputArray.length; i++) {
                arr[i] = Integer.parseInt(inputArray[i]);
            }

            int target = sc.nextInt();
            if (sc.hasNextLine())
                sc.nextLine(); // consume the newline after reading target

            Solution obj = new Solution();
            System.out.println(obj.numberOfSubarrays(arr, target));
        }

        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        // code here
        int n=arr.length;
        int left = 0, sum = 0, count = 0;

        // Traverse the array using the right pointer
        for (int right = 0; right < n; right++) {
            // Add the current element to the sum
            sum += arr[right];

            // Shrink the window from the left if the sum exceeds the target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // If the sum equals the target, count this subarray
            if (sum == target) {
                count++;

                // Additionally, check for all possible subarrays
                // that can be formed by moving the left pointer forward
                int tempLeft = left;
                while (tempLeft < right && arr[tempLeft] == 0) {
                    count++;
                    tempLeft++;
                }
            }
        }

        return count;
    }
}