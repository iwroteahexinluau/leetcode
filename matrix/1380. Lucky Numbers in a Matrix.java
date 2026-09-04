/* https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/
 * 1380. Lucky Numbers in a Matrix
 *
 * Initial Approach:
 * Loop through the matrix adding the max of each column to a set. Then, loop through the
 * matrix again adding the min of each row to an array. Then we can loop through the min
 * array checking if the number is in the set, and if it is we can add the result to the
 * return array.
 *
 * Time O(m * n), Space O(m + n)
 * m = # of rows, n = # of columns
 *
 * O(1) Space Solution:
 * From observing test cases and thinking about the problem, we can infer that there can
 * only be at most one lucky number in a matrix because a lucky number is the row minimum
 * and the column maximum. For this to occur, the lucky number has to be the largest of
 * the row minimums. So we can loop through the matrix keeping the max of each row
 * minimum, and then loop through the matrix again comparing the largest of row minimums
 * to the max of each column.
 *
 * Time O(m * n), Space O(1)
 * m = # of rows, n = # of columns
 * */

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    // initial approach
    public static List<Integer> luckyNumbersInMatrix(int[][] matrix) {
        int[] minRow = new int[matrix.length];
        List<Integer> luckyNumbers = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int i = 0; i < matrix[0].length; i++) {
            int max = matrix[0][i];
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(matrix[j][i], max);
            }
            seen.add(max);
        }

        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(matrix[i][j], min);
            }
            minRow[i] = min;
        }

        for (int i = 0; i < minRow.length; i++) {
            if (seen.contains(minRow[i])) {
                luckyNumbers.add(minRow[i]);
            }
        }
        return luckyNumbers;
    }
    // O(1) solution
    public static List<Integer> optimalSpaceLuckyNumbers(int[][] matrix) {
        List<Integer> luckyNumbers = new ArrayList<>();
        int largestRowMin = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int min = matrix[i][0];
            for (int j = 0; j < matrix[0].length; j++) {
                min = Math.min(matrix[i][j], min);
            }
            largestRowMin = Math.max(min, largestRowMin);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            int max = matrix[0][i];
            for (int j = 0; j < matrix.length; j++) {
                max = Math.max(matrix[j][i], max);
            }
            if (max == largestRowMin) {
                luckyNumbers.add(max);
                return luckyNumbers;
            }
        }
        return luckyNumbers;
    }

    public static void main(String[] args) {
        int[][] a = {{3, 7, 8}, {9, 11, 13}, {15, 16, 17}};
        int[][] b = {{1, 10, 4, 2}, {9, 3, 8, 7}, {15, 16, 17, 12}};
        int[][] c = {{7, 8}, {1, 2}};

        System.out.println(luckyNumbersInMatrix(a));
        System.out.println(luckyNumbersInMatrix(b));
        System.out.println(luckyNumbersInMatrix(c));
        
        System.out.println(optimalSpaceLuckyNumbers(a));
        System.out.println(optimalSpaceLuckyNumbers(b));
        System.out.println(optimalSpaceLuckyNumbers(c));
    }
}
