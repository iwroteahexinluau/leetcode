/* https://leetcode.com/problems/find-three-consecutive-integers-that-sum-to-a-given-number/description/
 * 2177. Find Three Consecutive Integers That Sum to a Given Number
 *
 * If a number can be expressed by three numbers as a sum, the values of the three
 * numbers are x - 1, x, x + 1. This simplifies to 3x, therefore any number that is
 * divisible by 3 can be expressed by three numbers as a sum.
 * This works for any odd number k of consecutive numbers, if it is divisible by k it can
 * be represented as k consecutive numbers.
 *
 * Time O(1), Space O(1)
 */

import java.util.Arrays;

class Solution {
    public static long[] findThreeConsecutiveInts(long num) {
        if (num % 3 == 0) {
            return new long[] {num / 3 - 1, num / 3, num / 3 + 1}; 
        } else {
            return new long[] {}; 
        }
    }

    public static void main(String[] args) {
        long a = 33;
        long b = 4;
        long c = 1000000000000000L;

        System.out.println(Arrays.toString(findThreeConsecutiveInts(a)));
        System.out.println(Arrays.toString(findThreeConsecutiveInts(b)));
        System.out.println(Arrays.toString(findThreeConsecutiveInts(c)));
    }
}
