/* https://leetcode.com/problems/maximum-subarray/description/
 * 53. Maximum Subarray
 *
 * We can solve this using dynamic programming, specifically Kadane's algorithm. We
 * keep a running total of the the maximum subarray that ends in every position. As we
 * check the current position, we compare the maximum subarray that ends in the prev
 * position + nums[i] with starting a brand new subarray with just nums[i].
 * nums = {1, 3, -4, 2, 7}
 * The maximum subarray that ends at index 0 is 1. Then we iterate to index 1 and take
 * the max of nums[1] and nums[1] + max at prev index. nums[1] + 1 is > nums[1], so the
 * maximum subarray that ends at index 1 is 4. Then we iterate to index 2 and repeat.
 * nums[2] < nums[2] + 4, so the maximum subarray that ends at index 2 is 0. This
 * repeats until the we reach the end of nums. We keep the value of the biggest subarray
 * that we come across and return it at the end.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int maximumSubarray(int[] nums) {
        int localMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] b = {1};
        int[] c = {5, 4, -1, 7, 8};

        System.out.println(maximumSubarray(a));
        System.out.println(maximumSubarray(b));
        System.out.println(maximumSubarray(c));
    }
}
