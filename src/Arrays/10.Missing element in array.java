//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            Solution sln = new Solution();
            System.out.println(sln.missingNumber(n, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

//Method -1
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        // Your Code Here
        int res;
        int sum1=(n*(n+1))/2;   //This will overflow if n=10^5; hence use XOR method
        int sum2=0;
        for(int i=0;i<n-1;i++){
            sum2+=arr[i];
        }
        res=sum1-sum2;
        return res;
    }
}
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
//Metho-2 using hash increasing the frequency and find the missing number

class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        // Your Code Here
        //int res=0;
        int[] hash=new int[n+1];
        for(int i=0;i<n-1;i++){
            hash[arr[i]]+=1;
        }
        for(int i=1;i<n;i++){
            if(hash[i]==0)
                return i;
        }
        return -1;
    }
}
/*-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
//Method-3
//This will take less time compared to summation method
class Solution {

    // Note that the size of the array is n-1
    int missingNumber(int n, int arr[]) {

        // Your Code Here
        int xor1=0;
        int xor2=0;
        for(int i=0;i<=n;i++)
            xor1=xor1^i;
        for(int i=0;i<n-1;i++)
            xor2=xor2^arr[i];
        return(xor1^xor2);
    }
}