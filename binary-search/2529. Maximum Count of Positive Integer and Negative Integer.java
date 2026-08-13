/* https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 * 2529. Maximum Count of Positive Integer and Negative Integer
 *
 * We need to find the number of positive and negative integers in the array. Since the
 * array is sorted, we can use a binary search to find the boundaries of where negative
 * numbers end, and the boundary where positive numbers start. We can find the negative
 * boundary by checking whether nums[mid] >= 0, and then searching to the left to find
 * the first non-negative integer, which indicates the end of negative numbers. We can 
 * find the positive boundary similary by checking whether nums[mid] > 0, then searching
 * to the left to find the first positive integer.
 *
 * Time O(log n), Space O(1)
 */

class Solution {
    public static int maxCount(int[] nums) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int positives = nums.length - low;

        low = 0;
        high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= 0) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        int negatives = low;
        return Math.max(negatives, positives);
    }

    public static void main(String[] args) {
        int[] a = {-2, -1, -1, 1, 2, 3};
        int[] b = {-3, -2, -1, 0, 0, 1, 2};
        int[] c = {5, 20, 66, 1314};
        int[] d = {-1, 0, 1};
        int[] e = {0};
        int[] f = {-3, -2, -1};

        System.out.println(maxCount(a));
        System.out.println(maxCount(b));
        System.out.println(maxCount(c));
        System.out.println(maxCount(d));
        System.out.println(maxCount(e));
        System.out.println(maxCount(f));
    }
}
