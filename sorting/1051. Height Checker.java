/* https://leetcode.com/problems/height-checker/description/
 * 1051. Height Checker
 *
 * We can sort the array and compare it to the original to determine how many positions
 * where heights[i] != expected[i]. Since the constraints are heights.length <= 100, I
 * chose to do a bubble sort.
 *
 * Time O(n^2), Space O(n)
 */

class Solution {
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        bubbleSort(copy);

        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 4, 2, 1, 3};
        int[] b = {5, 1, 2, 3, 4};
        int[] c = {1, 2, 3, 4, 5};

        System.out.println(heightChecker(a));
        System.out.println(heightChecker(b));
        System.out.println(heightChecker(c));
    } 
}
