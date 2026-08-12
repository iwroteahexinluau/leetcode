/* https://leetcode.com/problems/product-of-array-except-self/description/
 * 238. Product of Array Except Self
 *
 * To find the product of all numbers in an array except itself, we calculate the prefix,
 * the product of nums[0] -> nums[i - 1], and the suffix, the product of nums[i + 1] ->
 * nums[nums.length - 1]. On the first loop through, we can build the prefix storing the
 * prefix at every given position in the array in product[]. Then we loop backwards,
 * building the suffix at every given position and simultaneously calculating the
 * product, which is the prefix * suffix. The leftmost position has no prefix elements,
 * and the rightmost position has no suffix elements, so we start the prefix = nums[0]
 * and the suffix = nums[nums.length - 1], as well as start the loops one index inward
 * from the outer bounds.
 *
 * Time O(n), Space O(1)
 */

import java.util.Arrays;

class Solution {
    public static int[] productOfArrayExceptSelf(int[] nums) {
        int[] product = new int[nums.length];
        int prefix = nums[0];
        product[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            product[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            product[i] = product[i] * suffix;
            suffix *= nums[i];
        }
        return product;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {-1, 1, 0, -3, 3};
        int[] c = {2, 3};
        int[] d = {0, 2};
        int[] e = {0, 0};

        System.out.println(Arrays.toString(productOfArrayExceptSelf(a)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(b)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(c)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(d)));
        System.out.println(Arrays.toString(productOfArrayExceptSelf(e)));
    }
}
