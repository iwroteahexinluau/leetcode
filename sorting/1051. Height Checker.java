/* https://leetcode.com/problems/height-checker/description/
 * 1051. Height Checker
 *
 * Initial Approach:
 * We can sort the array and compare it to the original to determine how many positions
 * where heights[i] != expected[i]. Since the constraints are heights.length <= 100, we
 * can use a bubble sort. Alternatively, we can use the built in Arrays.sort() for 
 * O(nlog n) time complexity.
 *
 * Time O(n^2), Space O(n)
 *
 * Optimal Approach:
 * Since the constraints are heights.length <= 100 and heights[i] <= 100, we can build a
 * freq array and reconstruct the expected array in non-decreasing order.
 *
 * Time O(n), Space O(1)
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

    public static int optimalHeightChecker(int[] heights) {
        int[] freq = new int[101];
        for (int i = 0; i < heights.length; i++) {
            freq[heights[i]]++;
        }

        int pos = 0;
        int count = 0;
        for (int i = 1; i < freq.length; i++) {
            while (freq[i] > 0) {
                if (i != heights[pos]) {
                    count++;
                }
                pos++;
                freq[i]--;
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
        
        System.out.println(optimalHeightChecker(a));
        System.out.println(optimalHeightChecker(b));
        System.out.println(optimalHeightChecker(c));
    } 
}
