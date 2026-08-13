/* https://leetcode.com/problems/search-a-2d-matrix/description/
 * 74. Search a 2D Matrix
 *
 * Since the matrix is sorted in non-decreasing order, we can treat the 2D matrix as a
 * 1D array and then do a binary search to find target. The length of the 1D array is
 * rows * cols. After calculating the midpoint, we can find the position it would land on
 * in the 2D matrix with mid / cols, which gives us the row, and mid % cols, which gives
 * us the column. Then we check if num == target and move the high and low pointers as if
 * it is a binary search.
 *
 * Time O(log(m * n)), Space O(1)
 */

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int high = rows * cols;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int num = matrix[mid / cols][mid % cols];
            if (num == target) {
                return true;
            } else if (target < num) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       int[][] a = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
       int t = 3;
       int[][] b = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
       int t1 = 13;
       int[][] c = {{1,2,3}};
       int t2 = 4;
       int t3 = 3;

       System.out.println(searchMatrix(a, t));
       System.out.println(searchMatrix(b, t1));
       System.out.println(searchMatrix(c, t2));
       System.out.println(searchMatrix(c, t3));
    }
}
