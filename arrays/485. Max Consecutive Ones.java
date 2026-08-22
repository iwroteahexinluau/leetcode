/* https://leetcode.com/problems/max-consecutive-ones/description/
 * 485. Max Consecutive Ones
 *
 * We loop through nums counting the number of consecutive ones and keeping track of the
 * maximum window we've seen.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int maxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                current++;
            } else {
                max = Math.max(current, max);
                current = 0;
            }
        }
        return Math.max(current, max);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 0, 1, 1, 1};
        int[] b = {1, 0, 1, 1, 0, 1};
        int[] c = {1};
        int[] d = {0};

        System.out.println(maxConsecutiveOnes(a));
        System.out.println(maxConsecutiveOnes(b));
        System.out.println(maxConsecutiveOnes(c));
        System.out.println(maxConsecutiveOnes(d));
    }
}
