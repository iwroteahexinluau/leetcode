/* https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
 * 80. Remove Duplicates from Sorted Array II
 *
 * Very similar to the remove duplicates from sorted array problem, except this time a
 * number is allowed to be repeated once. Since the array is sorted, we only have to
 * track if it repeats until either it has repeated, or a new number is found. If the
 * number is valid, move it to the pointer.
 *
 * Time O(n), Space O(1)
 */

import java.util.Arrays;

class Solution {
    public static int removeDuplicates2(int[] nums) {
        int counter = 1;
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] && counter == 1) {
                counter++;
                nums[k] = nums[i];
                k++;
            } else if (nums[i] != nums[i - 1]) {
                counter = 1;
                nums[k] = nums[i];
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        int[] b = {0, 0, 1, 1, 1, 2, 3, 3};
        int[] c = {1, 2, 3, 4};

        System.out.println(removeDuplicates2(a));
        System.out.println(removeDuplicates2(b));
        System.out.println(removeDuplicates2(c));
    }
}
