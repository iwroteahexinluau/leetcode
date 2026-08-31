/* https://leetcode.com/problems/house-robber/description/
 * 198. House Robber
 *
 * We can approach this problem using dynamic programming. We store the maximum amount we
 * can rob up to the previous house and the second previous house. At each house, we have
 * two choices, we can skip the current house and keep prev, or choose to add the current
 * house to the maximum amount we can rob from the second previous house. We take the
 * larger of the two values.
 *
 * Time O(n), Space O(1)
 */


class Solution {
    public static int houseRobber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int twoPrev = nums[0];
        int prev = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(prev, twoPrev + nums[i]);
            twoPrev = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int[] b = {2, 7, 9, 3, 1};
        int[] c = {1, 7};
        int[] d = {2};
        int[] e = {1, 100, 10, 100, 1000};

        System.out.println(houseRobber(a));
        System.out.println(houseRobber(b));
        System.out.println(houseRobber(c));
        System.out.println(houseRobber(d));
        System.out.println(houseRobber(e));
    }
}
