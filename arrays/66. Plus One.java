/* https://leetcode.com/problems/plus-one/description/
 * 66. Plus One
 *
 * There is only one special case we have to handle, when the digit that is being added
 * to is 9. Otherwise we can add 1 to that position and return. When the digit is 9,
 * we set it to 0 and loop backwards continuing to add until a digit is not 9. In the
 * case that it reaches the end of the loop and still needs to carry, we increase the
 * size of the array.
 *
 * Time O(n), Space O(1)
 */

import java.util.Arrays;

class Solution {
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1]++;
            return digits;
        }

        for(int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        // need to increase size of array
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;

        return newDigits;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {4, 3, 2, 1};
        int[] c = {9};
        int[] d = {4, 2};
        int[] e = {0};
        int[] f = {1, 0};
        int[] g = {9, 9, 9};

        System.out.println(Arrays.toString(plusOne(a)));
        System.out.println(Arrays.toString(plusOne(b)));
        System.out.println(Arrays.toString(plusOne(c)));
        System.out.println(Arrays.toString(plusOne(d)));
        System.out.println(Arrays.toString(plusOne(e)));
        System.out.println(Arrays.toString(plusOne(f)));
        System.out.println(Arrays.toString(plusOne(g)));
    }
}
