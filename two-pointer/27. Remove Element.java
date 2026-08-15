/* https://leetcode.com/problems/remove-element/description/
 * 27. Remove Element
 *
 * We can use a two pointer approach keeping track of where to shift the values that do
 * not equal val.
 *
 * Time O(n), Space O(1)
 */

import java.util.Arrays;

class Solution {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[count] = nums[i];
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 3};
        int[] b = {0, 1, 2, 2, 3, 0, 4, 2};
        int a1 = 3, b1 = 2;

        System.out.println(removeElement(a, a1));
        System.out.println(removeElement(b, b1));
    }
}
