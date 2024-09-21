https://www.geeksforgeeks.org/problems/find-the-number-of-islands/0

//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m]; // Visited array
        int cnt = 0; // Island counter

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return cnt;
    }

    public void bfs(int row, int col, int[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));

        // These arrays define movement in all 8 possible directions
        int[] delRow = {-1, 0, 1, 0, -1, -1, 1, 1};
        int[] delCol = {0, 1, 0, -1, -1, 1, -1, 1};

        while (!q.isEmpty()) {
            int currRow = q.peek().first;
            int currCol = q.peek().second;
            q.remove();

            for (int i = 0; i < 8; i++) { // Loop over 8 possible neighbors
                int nrow = currRow + delRow[i];
                int ncol = currCol + delCol[i];

                // Check for valid bounds and unvisited land
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}