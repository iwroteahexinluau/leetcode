/* https://leetcode.com/problems/contains-duplicate/description/
 * 217. Contains Duplicate
 *
 * We can loop through the array once using a set to track seen values.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashSet;

class Solution {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (seen.contains(nums[i])) {
                return true;
            } else {
                seen.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 2, 3, 4};
        int[] c = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] d = {1};

        System.out.println(containsDuplicate(a));
        System.out.println(containsDuplicate(b));
        System.out.println(containsDuplicate(c));
        System.out.println(containsDuplicate(d));
    }
}
