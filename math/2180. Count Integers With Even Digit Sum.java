/* https://leetcode.com/problems/count-integers-with-even-digit-sum/description/
 * 2180. Count Integers With Even Digit Sum
 *
 * Initial Approach:
 * We loop through 2 -> num inclusive and check if each number's digits are even. Since
 * we are only counting positive integers, we start at 2, the first number with an even
 * digit sum.
 *
 * Time O(n * log n), Space O(1)
 * n = num
 *
 * Optimal Approach:
 * By observing which numbers have an even digit sum, we can notice a pattern.
 * 2, 4, 6, 8
 * 11, 13, 15, 17, 19
 * 20, 22, 24, 26, 28
 * 31, 33, 35, 37, 39
 * For each block of 10, excluding the first block, there are 5 numbers with an even
 * digit sum. For the first block, there are only 4, because 0 is not a positive integer.
 * If the digits excluding the last digit of the number sum to be odd, then for the
 * number to be an even digit sum, it must end in 1, 3, 5, 7, or 9. If the digits
 * excluding the last digit of the number sum to be even, then if the last digit is
 * 0, 2, 4, 6, 8, it is an even digit sum. So we check the sum of the digits of
 * num / 10, then check num % 10. This is asymptotically faster because we only have
 * to calculate the sum of the digits once.
 *
 * Time O(log n), Space O(1)
 * n = num
 */

class Solution {
    // initial approach
    public static int countIntegers(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            int sum = 0;
            int currentNum = i;
            while (currentNum > 0) {
                sum += currentNum % 10;
                currentNum /= 10;
            }
            if (sum % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // optimal approach
    public static int optimalCountIntegers(int num) {
        int blocks = num / 10;
        int total = blocks * 5 - 1; // subtract 1 for the initial 0
        int sum = 0;
        while (blocks > 0) {
            sum += blocks % 10;
            blocks /= 10;
        }

        if (sum % 2 == 0) {
            total += (num % 10 / 2) + 1;
        } else {
            total += (num % 10 + 1) / 2;
        }
        return total;
    }

    public static void main(String[] args) {
        int a = 4;
        int b = 30;
        int c = 1;
        int d = 11;
        int e = 100;
        int f = 13;

        System.out.println(countIntegers(a));
        System.out.println(countIntegers(b));
        System.out.println(countIntegers(c));
        System.out.println(countIntegers(d));
        System.out.println(countIntegers(e));
        System.out.println(countIntegers(f));

        System.out.println(optimalCountIntegers(a));
        System.out.println(optimalCountIntegers(b));
        System.out.println(optimalCountIntegers(c));
        System.out.println(optimalCountIntegers(d));
        System.out.println(optimalCountIntegers(e));
        System.out.println(optimalCountIntegers(f));
    }
}
