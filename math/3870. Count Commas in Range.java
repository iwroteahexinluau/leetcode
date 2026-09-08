/* https://leetcode.com/problems/count-commas-in-range/description/
 * 3870. Count Commas in Range
 *
 * Every number in the constraints 1 <= n <= 100,000 contains at most one comma. If
 * n >= 1000, each number from [1000, n] contains one comma, so the number of commas
 * is n - 999.
 *
 * Time O(1), Space O(1)
 */

class Solution {
    public static int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        return n - 999;
    }

    public static void main(String[] args) {
        int a = 1002;
        int b = 998;
        int c = 10425;
        int d = 5555;
        int e = 89425;

        System.out.println(countCommas(a));
        System.out.println(countCommas(b));
        System.out.println(countCommas(c));
        System.out.println(countCommas(d));
        System.out.println(countCommas(e));
    }
}
