https://www.geeksforgeeks.org/problems/subarrays-with-k-different-integers/0

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline character

        while (t-- > 0) {
            String[] arrInput = sc.nextLine().split(" ");
            int[] arr = new int[arrInput.length];
            for (int i = 0; i < arrInput.length; i++) {
                arr[i] = Integer.parseInt(arrInput[i]);
            }

            int k = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayCount(arr, k));
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int subarrayCount(int arr[], int k) {
        // code here
        return atMostKDistinct(arr, k) - atMostKDistinct(arr, k - 1);
    }

    static int atMostKDistinct(int arr[],int k)
    {
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, count = 0;

        for (int r = 0; r < n; r++) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            // If we have more than k distinct integers, shrink from the left
            while (map.size() > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }

            // Count the number of valid subarrays ending at r
            count += (r - l + 1);
        }

        return count;
    }
}
