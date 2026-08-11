/* https://leetcode.com/problems/reverse-integer/description/
 * 7. Reverse Integer
 *
 * Reversing an integer is simple, we can take the last digit of the number and add it
 * to our new reversed number. Every time we take another digit, we multiply the reversed
 * number by 10 to shift it to the left, then add the digit. We then divide the original
 * number by 10 and repeat until num = 0.
 *
 * The special case we have to watch out for is if the reversed number will be an integer
 * overflow. For positive integers, the max integer is 2^31 - 1 = 2147483647. Since we 
 * know that the input is an integer, the maximum number of total digits will not exceed
 * 10. So we know that the last left shift will be 214748364 * 10. Anything greater than
 * this will already exceed the max integer and therefore should be discarded. So we can
 * check if the reversed number > 214748364 before we apply the shift. We also have to
 * guard the case of anything <= 2147483647. So if reversed number == 214748364 before
 * the shift, we need to check the last digit. If the last digit > 7, then it is an
 * overflow. For negative numbers, we apply the exact same logic, other than the last
 * digit can be 8, as the min negative integer is -2^31 = -2147483647.
 *
 * Time O(d), Space O(1)
 * d = number of digits
 */

class Solution {
    public static int reverseInteger(int x) {
        int reversedNum = 0;
        // integer max / 10 == 214748364
        // if the next digit is > 7, it will be an overflow
        // same thing for negatives, except the digit can be 8
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;

        while (x != 0) {
            int digit = x % 10;

            if (reversedNum > max || reversedNum == max && digit > 7) {
                return 0;
            } else if (reversedNum < min || reversedNum == min && digit < -8) {
                return 0;
            }

            reversedNum = reversedNum * 10 + digit;
            x /= 10;
        }

        return reversedNum;
    }

    public static void main(String[] args) {
        int a = 123;
        int b = -123;
        int c = 120;
        int d = Integer.MAX_VALUE;
        int e = Integer.MIN_VALUE;

        System.out.println(reverseInteger(a));
        System.out.println(reverseInteger(b));
        System.out.println(reverseInteger(c));
        System.out.println(reverseInteger(d));
        System.out.println(reverseInteger(e));
    }
}
