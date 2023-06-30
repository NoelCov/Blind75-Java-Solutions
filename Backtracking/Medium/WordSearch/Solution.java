// Question link: https://leetcode.com/problems/word-search/

class Solution {
    // Time Complexity O(n * m * 4^k) where k is the length of the word.
    // Space Complexity O(k)
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, word, i, j, 0, rows, cols)) {
                    return true;
                }
                ;
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int currIdx, int rows, int cols) {
        if (currIdx >= word.length()) {
            return true;
        } else if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false;
        } else if (word.charAt(currIdx) != board[row][col]) {
            return false;
        }

        // This is so that we do not resue the same value twice.
        char temp = board[row][col];
        board[row][col] = '#';

        // We check top, left, right and bottom to see if we ever find the word.
        if ((backtrack(board, word, row - 1, col, currIdx + 1, rows, cols) ||
                backtrack(board, word, row, col - 1, currIdx + 1, rows, cols) ||
                backtrack(board, word, row, col + 1, currIdx + 1, rows, cols) ||
                backtrack(board, word, row + 1, col, currIdx + 1, rows, cols))) {
            return true;
        }

        // We reset at the end before it returns in case we haven't finished and we need
        // to use the value in the future.
        board[row][col] = temp;

        return false;
    }
}