https://www.geeksforgeeks.org/problems/second-largest3735/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//{ Driver Code Starts
//Initial Template for Java
import java.util.stream.Collectors;
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

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int a[], int n) {
        if(n<2) return -1;
        int largest = a[0];
        int secLargest = -1;
        for(int i=1; i<n; i++)
        {
            if(a[i]>largest)
            {
                secLargest = largest;
                largest = a[i];
            }else if(a[i]<largest && a[i]>secLargest)
            {
                secLargest = a[i];
            }
        }
        return secLargest;
    }
}