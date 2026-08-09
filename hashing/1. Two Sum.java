/* https://leetcode.com/problems/two-sum/description/
 * 1. Two Sum
 *
 * It is given that each input has exactly one solution. We know that the sum will be
 * nums[i] + x = target as we loop through the array, so we can use a hash map to check
 * if we have seen x. If we have not, add nums[i] to the hash map with the value of its
 * index.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                result[0] = seen.get(complement);
                result[1] = i;
            } else {
                seen.put(nums[i], i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] a = {2, 7, 11, 15};
        int[] b = {3, 2, 4};
        int[] c = {3, 3};
        int targetA = 9, targetB = 6, targetC = 6;

        System.out.println(Arrays.toString(twoSum(a, targetA)));
        System.out.println(Arrays.toString(twoSum(b, targetB)));
        System.out.println(Arrays.toString(twoSum(c, targetC)));
    }
}
