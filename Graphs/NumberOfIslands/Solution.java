package Graphs.NumberOfIslands;

// Question link: https://leetcode.com/problems/number-of-islands/

class Solution {
    // Time Complexity O(n * m)
    // Space Complexity O(n * m)
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(rows, cols, grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(int rows, int cols, char[][] grid, int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols && grid[row][col] == '1') {
            // Change curr value so that we do not visit this island again.
            grid[row][col] = '0';
            dfs(rows, cols, grid, row + 1, col);
            dfs(rows, cols, grid, row - 1, col);
            dfs(rows, cols, grid, row, col - 1);
            dfs(rows, cols, grid, row, col + 1);
        }
    }
}