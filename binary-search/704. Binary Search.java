/* https://leetcode.com/problems/binary-search/description/
 * 704. Binary Search
 *
 * We set the high and low bounds to the length of the array and 0. Then we calculate the
 * midpoint with low + (high - low) / 2. This avoids the possible integer overflow 
 * from using (high + low) / 2. Then we check nums[mid] with target. If target <
 * nums[mid], it means we need to move the high pointer and search again. We set high =
 * mid, not high = mid - 1, because we are searching [low, high), where high is not
 * inclusive. If target > nums[mid], it means we need to move the low pointer.
 *
 * Time O(log n), Space O(1)
 */

class Solution {
    public static int binarySearch(int[] nums, int target) {
        int high = nums.length;
        int low = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {-1, 0, 3, 5, 9, 12};
        int t = 9;
        int t1 = 2;

        System.out.println(binarySearch(a, t));
        System.out.println(binarySearch(a, t1));
    }
}
