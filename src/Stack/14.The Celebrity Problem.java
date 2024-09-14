https://www.geeksforgeeks.org/problems/the-celebrity-problem/1?page=1&category=Stack&sortBy=submissions

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n=mat.length;
        Stack<Integer> st=new Stack<>();

        for(int i=0; i<n; i++)
            st.push(i);

        while(st.size()>1)
        {
            int p1 = st.pop();
            int p2 = st.pop();

            if(mat[p1][p2]==1)
                st.push(p2);
            else
                st.push(p1);
        }
        int celeb = st.pop();

        for(int i=0; i<n; i++)
        {
            if(i!=celeb && mat[celeb][i]!=0)   return -1;
        }
        for(int i=0; i<n; i++)
        {
            if(i!=celeb && mat[i][celeb]!=1)   return -1;
        }
        return celeb;
    }
}