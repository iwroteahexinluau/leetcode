/* https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * 26. Remove Duplicates from Sorted Array
 *
 * We can loop through the array keeping track of the position in nums we need to shift
 * back to. If nums[i] is not a duplicate, we shift it and increment the count, which is
 * also the pointer for the position we shift back to. It is a given that nums.length >=
 * 1, so we can start the count at 1 because nums[0] will always be a unique element.
 * Then we can safely loop checking nums[i] with nums[i - 1] since it is a sorted array.
 * 
 * Time O(n), Space O(1)
 */

import java.util.Arrays;

class Solution {
    public static int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int[] b = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] c = {1, 2, 3, 4};

        System.out.println(removeDuplicates(a));
        System.out.println(removeDuplicates(b));
        System.out.println(removeDuplicates(c));
    }
}
