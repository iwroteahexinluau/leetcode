/* https://leetcode.com/problems/max-consecutive-ones-iii/
 * 1004. Max Consecutive Ones III
 *
 * We use a sliding window with two pointers that keeps track of the current number of
 * mistakes in the window. If mistakes > k, we move the left pointer to the first
 * position after a zero, removing a mistake. We also check to see if the window was the
 * biggest window we have seen.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int maxConsecutiveOnes3(int[] nums, int k) {
        int max = 0, mistakes = 0, left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                mistakes++;
            }
            if (mistakes > k) {
                max = Math.max(max, right - left);
                // find first zero
                while(nums[left] != 0) {
                    left++;
                }
                // move past zero
                left++;
                mistakes -= 1;
            }
            right++;
        }
        return Math.max(max, right - left);
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] b = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int[] c = {0, 0, 0, 0};
        int[] d = {1, 1, 1};
        int k0 = 0, k1 = 1, k2 = 2, k3 = 3;

        System.out.println(maxConsecutiveOnes3(a, k2));
        System.out.println(maxConsecutiveOnes3(b, k3));
        System.out.println(maxConsecutiveOnes3(c, k0));
        System.out.println(maxConsecutiveOnes3(c, k1));
        System.out.println(maxConsecutiveOnes3(d, k3));
        System.out.println(maxConsecutiveOnes3(d, k0));
    }
}
