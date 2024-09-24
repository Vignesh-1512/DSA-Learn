https://www.geeksforgeeks.org/problems/sum-palindrome3857/1

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isSumPalindrome(n));
        }
    }
}
// } Driver Code Ends




// User function Template for Java
class Solution {
    static long isSumPalindrome(long n) {
        // code here
        if(isPalindrome(n)){
            return n;
        }
        for(int i=0;i<5;i++){
            n+=reverse(n);
            if(isPalindrome(n)){
                return n;
            }
        }
        return -1;
    }
    static long reverse(long n){
        long reversed=0;
        while(n!=0){
            reversed=(reversed*10)+n%10;
            n=n/10;
        }
        return reversed;
    }
    static boolean isPalindrome(long n){
        return n==reverse(n);
    }
}