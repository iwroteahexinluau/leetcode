/* https://leetcode.com/problems/count-commas-in-range-ii/description/
 * 3871. Count Commas in Range II
 *
 * The comma thresholds increase by a factor of 1000, so we can sum the number of commas
 * in each range, and increase our placeholder to reach the next range. If n > place,
 * then the number of commas in that range is n - place;
 *
 * Time O(log n), Space O(1)
 * The loop runs once for each commas threshold, 1000, 1000000, etc, but is effectively
 * O(1) for the constraints of this problem.
 */

class Solution {
    public static long countCommas2(long n) {
        long commas = 0;
        long place = 999;
        while (n > place) {
            commas += n - place;
            place *= 1000;
            place += 999;
        }
        return commas;
    }

    public static void main(String[] args) {
        long a = 1002;
        long b = 998;
        long c = 109232;
        long d = 999999999;
        long e = 102328938232l;

        System.out.println(countCommas2(a));
        System.out.println(countCommas2(b));
        System.out.println(countCommas2(c));
        System.out.println(countCommas2(d));
        System.out.println(countCommas2(e));
    }
}

