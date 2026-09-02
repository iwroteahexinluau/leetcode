/* https://leetcode.com/problems/house-robber-ii/description/
 * 213. House Robber II
 *
 * We can approach this the same as the House Robber problem. Since the last house is
 * adjacent to the first house, there are two scenarios that can happen. We can either
 * exclude the last house, or we can exclude the first house since the two houses cannot
 * be robbed together. We use the dynamic programming House Robber algorithm on both
 * ranges and take the maximum of the two.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int houseRobber2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int twoPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            int current = Math.max(prev, twoPrev + nums[i]);
            twoPrev = prev;
            prev = current;
        }
        int excludingLast = prev;

        twoPrev = nums[1];
        prev = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int current = Math.max(prev, twoPrev + nums[i]);
            twoPrev = prev;
            prev = current;
        }
        return Math.max(excludingLast, prev);
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 2};
        int[] b = {1, 2, 3, 1};
        int[] c = {1, 2, 3};

        System.out.println(houseRobber2(a));
        System.out.println(houseRobber2(b));
        System.out.println(houseRobber2(c));
    }
}
