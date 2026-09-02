/* https://leetcode.com/problems/construct-uniform-parity-array-i/description/
 * 3875. Construct Uniform Parity Array I
 *
 * If all numbers are already all odd or all even, then we can keep every number and the
 * condition is satisfied. Otherwise the array contains at least one odd number. We can
 * then turn every even number into an odd number by subtracting the odd number from the
 * even number. Since every even - odd = odd, every element can be made odd and therefore
 * every input will satisfy the condition and be true.
 *
 * Time O(1), Space O(1)
 */

class Solution {
    public static boolean constructUniform(int[] nums) {
        return true;
    }

    public static void main(String[] args) {
        int[] a = {2, 3};
        int[] b = {4, 6};

        System.out.println(constructUniform(a));
        System.out.println(constructUniform(b));
    }
}
