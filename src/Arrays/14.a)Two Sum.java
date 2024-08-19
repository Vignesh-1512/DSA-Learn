https://www.geeksforgeeks.org/problems/key-pair5616/1?itm_source=geeksforgeeks&itm_medium=Article&itm_campaign=bottom_sticky_on_Article

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().hasArrayTwoCandidates(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean hasArrayTwoCandidates(int arr[], int x) {
        // code here
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(arr[i]+arr[j]==x){
                    return true;
                }

            }
        }
        return false;
    }
}
/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------*/
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int x) {
        // code here
        int n=arr.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){

                if(arr[i]+arr[j]==x){
                    return true;
                }

            }
        }
        return false;
    }
}
/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------*/
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int x) {
        // code here
        int n=arr.length;
        Map<Integer, Integer> mpp=new HashMap<>();

        for(int i=0;i<n;i++){
            int num=arr[i];
            int more=x-num;
            if(mpp.containsKey(more)){
                return true;
            }
            mpp.put(arr[i],i);
        }
        return false;
    }
}

/*----------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------------------------------*/
class Solution {
    boolean hasArrayTwoCandidates(int arr[], int x) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        int left=0,right=n-1;


        while(left<right)
        {
            int sum=arr[left]+arr[right];
            if(sum==x){
                return true;
            }
            else if(sum>x) right--;
            else left++;
        }
        return false;
    }
}

