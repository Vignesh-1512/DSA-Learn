https://www.geeksforgeeks.org/problems/subset-sums2234/1

//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        solve(arr, n, 0, 0,ans );
        return ans;
    }

    public void solve(ArrayList<Integer> arr, int n, int idx, int sum, ArrayList<Integer>ans)
    {
        if(idx==n)
        {
            ans.add(sum);
            return;
        }

        solve(arr, n, idx+1, sum+arr.get(idx), ans);
        solve(arr, n, idx+1, sum, ans);
    }
}