https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr, int n) {

        //Tc:O(N) bcoz till we find index where zero is present, half of the array gets traversed
        //then we traverse the remaining array
        //hence O(N) will be the Tc
        int j = -1;
        for(int i=0; i<n; i++)
        {
            if(arr[i]==0)
            {
                j=i; break;
            }
        }
        if (j == -1) return ;
        for(int i=j+1; i<n; i++)
        {
            if(arr[i]!=0)
            {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                j++;
            }
        }

    }
}