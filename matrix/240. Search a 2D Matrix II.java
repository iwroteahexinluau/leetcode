/* https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * 240. Search a 2D Matrix II
 *
 * Since the row is sorted left to right and the columns are sorted from top to bottom,
 * we can eliminate the possibility of target being in a column or row by comparing it to
 * the first value of a column and the last value of a row. If we look at the 2D array,
 * the first value in each column is the lowest value in that column. So if we compare
 * the num at that position with target, and target is smaller, we know that the target
 * cannot be any other value in that column and therefore we can eliminate that column
 * completely. Likewise, if we choose the last value in a row and compare the num with
 * target, if target is bigger, we know that the target cannot be any other value in that
 * row. So we start in the top right position of the matrix, matrix[0][matrix[0].length - 1],
 * and loop through until we have checked every column and every row in the matrix. If
 * target is smaller than matrix[r][c] we shift left one column, and if target is larger
 * than matrix[r][c] we shift one down one row.
 *
 * Time O(m + n), Space O(1)
 * m = rows, n = columns
 * Worst case, we check every row and column of the matrix and don't find target.
 */

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix[0].length - 1;
        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int t1 = 5, t2 = 20;

        System.out.println(searchMatrix(a, t1));
        System.out.println(searchMatrix(a, t2));
    }
}
