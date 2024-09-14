https://www.geeksforgeeks.org/problems/smallest-number-on-left3403/1

//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a1[] = in.readLine().trim().split("\\s+");
            int a[] = new int[n];
            for(int i = 0;i < n;i++)
                a[i] = Integer.parseInt(a1[i]);
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.leftSmaller(n, a);
            for(int i = 0;i < n;i++)
                System.out.print(ans.get(i)+" ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        //code here
        // List to store the result (nearest smaller elements to the left)
        List<Integer> nse = new ArrayList<>();

        // Stack to track the elements
        Stack<Integer> st = new Stack<>();

        // Traverse each element in the array
        for (int i = 0; i < n; i++) {
            // Pop elements from the stack until we find a smaller element
            while (!st.isEmpty() && st.peek() >= a[i]) {
                st.pop();
            }

            // If stack is empty, no smaller element to the left
            if (st.isEmpty()) {
                nse.add(-1);
            } else {
                // The top of the stack is the nearest smaller element
                nse.add(st.peek());
            }

            // Push the current element to the stack
            st.push(a[i]);
        }

        return nse; // Return the result list
    }
}