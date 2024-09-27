https://www.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] mat = new int[n][n];
            String[] S = br.readLine().trim().split(" ");
            int i = 0;
            int j = 0;
            for(int k = 0; k < S.length; k++){
                mat[i][j] = Integer.parseInt(S[k]);
                j++;
                if(j == n){
                    i++;
                    j = 0;
                }
            }
            Solution obj = new Solution();
            int[] ans = obj.matrixDiagonally(mat);
            for(int it = 0; it < ans.length; it++){
                System.out.print(ans[it] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length; // Handle non-square matrices too
        int[] ans = new int[n * m];
        int i = 0, j = 0;
        boolean isUp = true; // Start moving upwards

        for (int k = 0; k < n * m;) {
            if (isUp) {
                // Move upwards diagonally
                while (i >= 0 && j < m) {
                    ans[k++] = mat[i--][j++]; // Store the value and move up-right
                }

                // Correcting indices when going out of bounds
                if (j < m) {
                    i = 0; // Move to the next row if within matrix bounds
                } else {
                    i += 2; // Move down two rows if the end of column is hit
                    j--;
                }
            } else {
                // Move downwards diagonally
                while (j >= 0 && i < n) {
                    ans[k++] = mat[i++][j--]; // Store the value and move down-left
                }

                // Correcting indices when going out of bounds
                if (i < n) {
                    j = 0; // Move to the next column if within matrix bounds
                } else {
                    j += 2; // Move right two columns if the end of row is hit
                    i--;
                }
            }

            // Flip the direction
            isUp = !isUp;
        }
        return ans;
    }
}
