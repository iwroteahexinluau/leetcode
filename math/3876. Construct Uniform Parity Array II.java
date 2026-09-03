/* https://leetcode.com/problems/construct-uniform-parity-array-ii/description/
 * 3876. Construct Uniform Parity Array II
 *
 * There are three scenarios where we can construct another uniform array from nums such
 * that all of the elements in the new array are all odd or odd even. If the original
 * array nums is all odd or all even, then the condition is true. If there is at least
 * one odd number, we can make each even number in the original array odd by subtracting
 * the odd number. However, we can only do this if nums1[i] - nums1[j] >= 1, so we need
 * to check if every even number - the lowest odd number is >= 1. We can do this by
 * finding the lowest even number and subtracting the lowest odd number. If this is >= 1,
 * then every other even number in the array can be turned into an odd number and thus
 * the condition is true.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static boolean constructParity2(int[] nums) {
        int lowestOdd = Integer.MAX_VALUE;
        int lowestEven = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                lowestEven = Math.min(lowestEven, nums[i]);
            } else {
                lowestOdd = Math.min(lowestOdd, nums[i]);
            }
        }
        if (lowestOdd == Integer.MAX_VALUE || lowestEven == Integer.MAX_VALUE || lowestEven - lowestOdd >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 7};
        int[] b = {2, 3};
        int[] c = {4, 6};

        System.out.println(constructParity2(a));
        System.out.println(constructParity2(b));
        System.out.println(constructParity2(c));
    }
}
