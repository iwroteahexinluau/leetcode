/* https://leetcode.com/problems/valid-sudoku/description/
 * 36. Valid Sudoku
 *
 * We can use a set to check whether a number has already been seen in each row, column,
 * and 3x3 box. If the number has been seen, we can immediately return false, otherwise
 * we add it to the set. After each row, column, and box, we clear the set to reuse it.
 *
 * Time O(n), Space O(1)
 * n = number of board squares
 */

import java.util.HashSet;

class Solution {
    public static boolean validSudoku(char[][] board) {
        HashSet<Character> seenRow = new HashSet<>();
        HashSet<Character> seenCol = new HashSet<>();

        // checks rows and columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (seenRow.contains(board[i][j])) {
                    return false;
                } else if (board[i][j] != '.') {
                    seenRow.add(board[i][j]);
                }
                if (seenCol.contains(board[j][i])) {
                    return false;
                } else if (board[j][i] != '.') {
                    seenCol.add(board[j][i]);
                }
            }
            seenRow.clear();
            seenCol.clear();
        }

        // checks 3x3 boxes
        HashSet<Character> seenBox = new HashSet<>();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int row = i; row < i + 3; row++) {
                    for (int col = j; col < j + 3; col++) {
                        if (seenBox.contains(board[row][col])) {
                            return false;
                        } else if (board[row][col] != '.') {
                            seenBox.add(board[row][col]);
                        }
                    }
                }
                seenBox.clear();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] a = {{'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};

        char[][] b = {{'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(validSudoku(a));
        System.out.println(validSudoku(b));
    }
}
