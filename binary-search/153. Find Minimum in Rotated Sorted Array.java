/* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 * 153. Find Minimum in Rotated Sorted Array
 *
 * We want to the find the minimum in a sorted array that may have been rotated.
 * We can use a binary search and compare nums[mid] with nums[high].
 *
 * If nums[high] < nums[mid], the minimum must be in the range [mid + 1, high], so
 * we set low = mid + 1.
 * Otherwise, the minimum is in the range [low, mid], so we set high = mid.
 *
 * Eventually low == high and that index contains the minimum value.
 *
 * Time O(log n), Space O(1)
 */

class Solution {
    public static int findMinimum(int[] nums) {
        int low = 0;
        // since we use high as an index, high must be inclusive bounds
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[high] < nums[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 1, 2};
        int[] b = {4, 5, 6, 7, 0, 1, 2};
        int[] c = {11, 13, 15, 17};
        int[] d = {2, 1};
        int[] e = {5};

        System.out.println(findMinimum(a));
        System.out.println(findMinimum(b));
        System.out.println(findMinimum(c));
        System.out.println(findMinimum(d));
        System.out.println(findMinimum(e));
    }
}
