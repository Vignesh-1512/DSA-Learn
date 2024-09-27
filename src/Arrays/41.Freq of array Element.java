https://www.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // size of array
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int P = Integer.parseInt(br.readLine().trim());
            // calling frequncycount() function
            Solution ob = new Solution();
            ob.frequencyCount(arr, N, P);

            // printing array elements
            for (int i = 0; i < N; i++) System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P) {
        // Create a HashMap to count the frequency of elements in the range [1, N]
        HashMap<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies of elements in the range [1, N]
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 1 && arr[i] <= N) {
                freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
            }
        }

        // Step 2: Update the array with the frequencies
        for (int i = 0; i < N; i++) {
            // If the number i+1 is in the map, set its frequency, else set 0
            arr[i] = freqMap.getOrDefault(i + 1, 0);
        }
    }
}
