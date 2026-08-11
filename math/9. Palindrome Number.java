/* https://leetcode.com/problems/palindrome-number/description/
 * 9. Palindrome Number
 *
 * Optimal Approach:
 * If x is a negative number, or has a trailing zero and is not zero, it cannot be a
 * palindrome number. We can split x into two halves, and compare the first half with the
 * second half. We can build the reversed number by shifting the current reversed num to
 * the left by multiplying by 10, then adding the next digit to it. As soon as reversed
 * becomes >= x, we stop and compare the two numbers. We have to guard the case of an odd
 * amount of digits where the middle most number does not matter. So we also check if
 * x == reversed / 10 to remove the odd digit if it exists. We know this will not catch
 * a false positive because we are adding one digit everytime, and reversed will at
 * maximum be one digit more, which will be the middle digit.
 */

class Solution {
    // optimal approach
    public static boolean optimalPalindromeNumber(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    /* intial approach of getting the place of the leftmost digit then comparing the left
     * digit and the right digit. if they match, remove the digit on the left and right
     * and repeat.
     * Time O(log x) or O(d), Space O(1)
     * d = number of digits
     */
    public static boolean palindromeNumber(int x) {
        if (x < 0) {
            return false;
        }

        int place = 1;
        int temp = x;
        while (temp > 9) {
            place *= 10;
            temp /= 10;
        }

        while (x > 0) {
            if (x % 10 != x / place) {
                return false;
            }
            x %= place;
            x /= 10;
            place /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        int a = 121;
        int b = -121;
        int c = 10;
        int d = 1221;
        int e = 12321;
        int f = 1011;
        int g = 111;
        int h = 1111;

        System.out.println(palindromeNumber(a));
        System.out.println(palindromeNumber(b));
        System.out.println(palindromeNumber(c));
        System.out.println(palindromeNumber(d));
        System.out.println(palindromeNumber(e));
        System.out.println(palindromeNumber(f));
        System.out.println(palindromeNumber(g));
        System.out.println(palindromeNumber(h));

        System.out.println(optimalPalindromeNumber(a));
        System.out.println(optimalPalindromeNumber(b));
        System.out.println(optimalPalindromeNumber(c));
        System.out.println(optimalPalindromeNumber(d));
        System.out.println(optimalPalindromeNumber(e));
        System.out.println(optimalPalindromeNumber(f));
        System.out.println(optimalPalindromeNumber(g));
        System.out.println(optimalPalindromeNumber(h));
    }
}
