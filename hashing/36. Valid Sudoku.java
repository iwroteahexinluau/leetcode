/* https://leetcode.com/problems/valid-sudoku/description/
 * 36. Valid Sudoku
 *
 * Initial Approach:
 * We can use a set to check whether a number has already been seen in each row, column,
 * and 3x3 box. If the number has been seen, we can immediately return false, otherwise
 * we add it to the set. After each row, column, and box, we clear the set to reuse it.
 *
 * Optimized Approach:
 * We can use three 2d boolean arrays instead of sets, and check each row, column, and
 * 3x3 box in one pass. The 2d boolean array represents the row/col/box and the digit
 * value. We can calculate the current box with box = i / 3 * 3 + j / 3;
 *
 * Time O(1), Space O(1)
 * Since the Sudoku board has a constant of 81 squares, the time and space complexity
 * is fixed at O(1). If the board had n total cells, the time and space complexity would
 * be O(n), where n = number of board squares.
 */

import java.util.HashSet;

class Solution {
    // initial approach
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

    // optimized approach
    public static boolean optimizedValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1'; // makes the digits 1-9 -> 0-8 to match zero index
                int box = i / 3 * 3 + j / 3;

                if (rows[i][num] || cols[j][num] || boxes[box][num]) {
                    return false;
                }
                rows[i][num] = cols[j][num] = boxes[box][num] = true;
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

        System.out.println(optimizedValidSudoku(a));
        System.out.println(optimizedValidSudoku(b));
    }
}
