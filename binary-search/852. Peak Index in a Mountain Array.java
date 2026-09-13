/* https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 * 852. Peak Index in a Mountain Array
 *
 * We want to find the peak element in an array that is strictly increasing to the peak
 * element and then decreasing. We can use a binary search to check if nums[mid] <
 * nums[mid + 1]. If nums[mid] < nums[mid + 1], we know that the peak element must be
 * to the right, so we set low = mid + 1. If nums[mid] >= nums[mid + 1], we know the peak
 * element must be mid or to the left, so we set high = mid.
 *
 * Time O(log n), Space O(1)
 */

class Solution {
    public static int peakIndexInMountain(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0};
        int[] b = {0, 2, 1, 0};
        int[] c = {0, 10, 5, 2};
        int[] d = {1, 2, 3, 2};
        int[] e = {1, 5, 4, 3};

        System.out.println(peakIndexInMountain(a));
        System.out.println(peakIndexInMountain(b));
        System.out.println(peakIndexInMountain(c));
        System.out.println(peakIndexInMountain(d));
        System.out.println(peakIndexInMountain(e));
    }
}
