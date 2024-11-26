package Graph;

import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char[] TARGET = {'Z', 'O', 'H', 'O'};

    static List<List<Integer>> findShortestPath(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[rows][cols][TARGET.length];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == TARGET[0]) {
                    queue.add(new int[]{r, c, 0});
                    visited[r][c][0] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0], c = node[1], idx = node[2];

            if (idx == TARGET.length - 1) {
                return reconstructPath(r, c, idx, visited);
            }

            for (int[] dir : DIRECTIONS) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                int newIdx = idx + 1;

                if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] == TARGET[newIdx] && !visited[newRow][newCol][newIdx]) {
                    queue.add(new int[]{newRow, newCol, newIdx});
                    visited[newRow][newCol][newIdx] = true;
                }
            }
        }

        return Collections.emptyList();
    }

    private static boolean isValid(int r, int c, int rows, int cols) {
        return r >= 0 && c >= 0 && r < rows && c < cols;
    }

    private static List<List<Integer>> reconstructPath(int r, int c, int idx, boolean[][][] visited) {
        List<List<Integer>> path = new ArrayList<>();
        while (idx >= 0) {
            path.add(Arrays.asList(r, c));
            for (int[] dir : DIRECTIONS) {
                int prevR = r - dir[0];
                int prevC = c - dir[1];
                if (isValid(prevR, prevC, visited.length, visited[0].length) && visited[prevR][prevC][idx - 1]) {
                    r = prevR;
                    c = prevC;
                    break;
                }
            }
            idx--;
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'A', 'Z', 'T', 'E', 'C'},
                {'O', 'Z', 'O', 'N', 'E'},
                {'H', 'O', 'M', 'E', 'S'},
                {'S', 'O', 'L', 'I', 'D'}
        };

        List<List<Integer>> path = findShortestPath(grid);
        System.out.println(path);
    }
}
