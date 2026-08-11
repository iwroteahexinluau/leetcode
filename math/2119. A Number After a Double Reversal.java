/* https://leetcode.com/problems/a-number-after-a-double-reversal/description/
 * 2119. A Number After a Double Reversal
 *
 * Standard Approach:
 * We can get each digit with num % 10. Before adding the digit, we shift the reversed
 * number to the left by multiplying by 10. This ensures that the first digit, the
 * rightmost digit of the number, will be the leftmost digit of the new number, thus
 * reversing the number. We reverse the number again to get the double reversed number.
 *
 * Time O(d), Space O(1)
 *
 * Most Optimal Approach:
 * By observing reversed numbers, we can come to the conclusion that trailing zeroes
 * on the number are lost when reversed. Therefore, if there are no trailing zeroes,
 * the number double reversed will be the same number. So we can just return true if
 * the number does not have a trailing zero. We also have to guard against the case
 * num = 0, because it has a trailing zero, but 0 reversed = 0.
 *
 * Time O(1), Space O(1)
 */

class Solution {
    public static int reverseNum(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public static boolean canDoubleReverse(int num) {
        int reversed = reverseNum(num);
        return num == reverseNum(reversed);
    }

    public static boolean optimalDoubleReverse(int num) {
        return num == 0 || num % 10 != 0;
    }


    public static void main(String[] args) {
        int a = 526;
        int b = 1800;
        int c = 0;

        System.out.println(canDoubleReverse(a));
        System.out.println(canDoubleReverse(b));
        System.out.println(canDoubleReverse(c));

        System.out.println(optimalDoubleReverse(a));
        System.out.println(optimalDoubleReverse(b));
        System.out.println(optimalDoubleReverse(c));
    }
}
