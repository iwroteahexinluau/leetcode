/* https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/
 * 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 *
 * A prefix is sequential if it starts at nums[0], nums[1] = nums[0] + 1, etc. The next
 * value in the array must be one higher than the previous. We can loop through the array
 * summing the prefix until it is no longer valid. Then, we finish looping adding nums[i]
 * to a set. We then find the the smallest integer that is greather than or equal to the
 * sum by checking if sum is in the set. If it is not, we increment by 1 and check again.
 *
 * Since nums[0] is the smallest sequential prefix by default, and we start the loop at
 * i = 1, we have to add nums[0] to the set and the starting sum.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashSet;

class Solution {
    public static int smallestMissing(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        
        // nums[0] is the smallest sequential prefix by default
        seen.add(nums[0]);
        int sum = nums[0];
        boolean canContinue = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i] && canContinue) {
                sum += nums[i];
            } else {
                canContinue = false;
            }
            seen.add(nums[i]);
        }

        while (seen.contains(sum)) {
            sum++;
        }
        return sum;
   }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 5};
        int[] b = {3, 4, 5, 1, 12, 14, 13};
        int[] c = {1, 2};
        int[] d = {5, 1};
        int[] e = {1};
        int[] f = {3, 1, 2};

        System.out.println(smallestMissing(a));
        System.out.println(smallestMissing(b));
        System.out.println(smallestMissing(c));
        System.out.println(smallestMissing(d));
        System.out.println(smallestMissing(e));
        System.out.println(smallestMissing(f));
    }
}
