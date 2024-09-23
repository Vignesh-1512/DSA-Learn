https://www.geeksforgeeks.org/problems/maximum-point-you-can-obtain-from-cards/1

//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // code here.
        int n=cardPoints.length;
        int lSum=0, rSum=0, maxSum=0;
        for(int i=0;i<k;i++) lSum=lSum+cardPoints[i];
        maxSum=lSum;

        int r=n-1;
        for(int i=k-1;i>=0;i--)
        {
            rSum=rSum+cardPoints[r];
            r--;
            lSum=lSum-cardPoints[i];

            maxSum=Math.max(maxSum,lSum+rSum);
        }
        return maxSum;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            int[] cardPoints = new int[inputArray.length];
            for (int j = 0; j < inputArray.length; j++) {
                cardPoints[j] = Integer.parseInt(inputArray[j]);
            }
            int k = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            Solution solution = new Solution();
            System.out.println(solution.maxScore(cardPoints, k));
        }

        scanner.close();
    }
}

// } Driver Code Ends