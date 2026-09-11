/* https://leetcode.com/problems/search-insert-position/description/
 * 35. Search Insert Position
 *
 * We can use a binary search to look for the target value. If the target value is not
 * found, we return low, which will be the index where the binary search stops, and
 * the index where the target value would be.
 */

class Solution {
    public static int searchInsertPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int t1 = 5, t2 = 2, t3 = 7;

        System.out.println(searchInsertPosition(a, t1));
        System.out.println(searchInsertPosition(a, t2));
        System.out.println(searchInsertPosition(a, t3));
    }
}
