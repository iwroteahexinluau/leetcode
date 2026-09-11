/* https://leetcode.com/problems/find-peak-element/description/ 
 * 162. Find Peak Element
 *
 * We can use a binary search and compare nums[mid] to nums[mid + 1]. If nums[mid] <
 * nums[mid + 1], then there must be a peak to the right and we set low = mid + 1.
 * Otherwise there must be a peak at mid or to the left, so we set high = mid.
 *
 * Time O(log n), Space O(1)
 */

class Solution {
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 2, 1, 3, 5, 6, 4};
        int[] c = {1, 2, 3, 4, 5, 6, 1};
        int[] d = {1, 2, 3, 4, 5};
        int[] e = {8, 3, 2, 3, 5};
        int[] f = {1};
        int[] g = {2, 1};
        int[] h = {1, 2};

        System.out.println(findPeakElement(a));
        System.out.println(findPeakElement(b));
        System.out.println(findPeakElement(c));
        System.out.println(findPeakElement(d));
        System.out.println(findPeakElement(e));
        System.out.println(findPeakElement(f));
        System.out.println(findPeakElement(g));
        System.out.println(findPeakElement(h));
    }
}
