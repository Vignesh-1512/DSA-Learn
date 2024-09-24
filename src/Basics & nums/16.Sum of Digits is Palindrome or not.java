https://www.geeksforgeeks.org/problems/sum-of-digit-is-pallindrome-or-not2751/1?page=1&difficulty=School&sortBy=submissions

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
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int isDigitSumPalindrome(int n) {
        // code here
        if(n<10) return 1;
        int sum=0;
        int temp=n;
        while(temp>0){
            sum+=temp%10;
            temp=temp/10;
        }

        String sumString=Integer.toString(sum);
        int left=0;
        int right=sumString.length()-1;

        while(left<right){
            if(sumString.charAt(left)!=sumString.charAt(right)){
                return 0;
            }

            left++;
            right--;


        }
        return 1;
    }
}