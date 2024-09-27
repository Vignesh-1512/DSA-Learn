https://www.geeksforgeeks.org/problems/count-the-triplets4615/1

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            int n = Integer.parseInt(read.readLine());
            String input[] = read.readLine().split(" ");

            int arr[] = new int[n];
            for(int i = 0;i<n;i++){
                arr[i] = Integer.parseInt(input[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.countTriplet(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countTriplet(int arr[], int n) {
        // code here
        Arrays.sort(arr);
        int count = 0;

        // Traverse each element and use two-pointer technique to find pairs that sum to the current element
        for (int i = n - 1; i >= 0; i--) {
            int left = 0;
            int right = i - 1;

            while (left < right) {
                // If sum of arr[left] and arr[right] equals arr[i], it's a valid triplet
                if (arr[left] + arr[right] == arr[i]) {
                    count++;  // Increment the count
                    left++;   // Move the left pointer
                    right--;  // Move the right pointer
                }
                // If the sum is less than arr[i], move the left pointer to increase the sum
                else if (arr[left] + arr[right] < arr[i]) {
                    left++;
                }
                // If the sum is greater than arr[i], move the right pointer to decrease the sum
                else {
                    right--;
                }
            }
        }

        return count;
    }
}