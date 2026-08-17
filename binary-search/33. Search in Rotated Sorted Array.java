/* https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * 33. Search in Rotated Sorted Array
 *
 * The optimal approach is using a binary search to find the target. Since we know that
 * the array is sorted, but has been rotated, at any given midpoint, one half of the
 * array will be sorted. We can only use a binary search on the half that is sorted, so
 * we check the midpoint and determine which half is the sorted half. We check if target
 * is inside the sorted half, if it is not, we know it must be in the other half.
 *
 * Time O(log n), Space O(1)
 */

class Solution {
    public static int searchRotatedSortedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            // bottom half is sorted
            } else if (nums[low] < nums[mid]) {
                // target is in the sorted half
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid;
                // target is not in the sorted half
                } else {
                    low = mid + 1;
                }
            // top half is sorted
            } else {
                // target is in the sorted half
                if (target > nums[mid] && target <= nums[high - 1]) {
                    low = mid + 1;
                // target is not in the sorted half
                } else {
                    high = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int t = 0, t1 = 3;
        int[] b = {1};
        int t2 = 0;
        int[] c = {6, 7, 8, 0, 1, 2, 3, 4, 5};
        int t3 = 8, t4 = 5, t5 = 6, t6 = 0;

        System.out.println(searchRotatedSortedArray(a, t));
        System.out.println(searchRotatedSortedArray(a, t1));
        System.out.println(searchRotatedSortedArray(b, t2));
        System.out.println(searchRotatedSortedArray(c, t3));
        System.out.println(searchRotatedSortedArray(c, t4));
        System.out.println(searchRotatedSortedArray(c, t5));
        System.out.println(searchRotatedSortedArray(c, t6));
    }
}
