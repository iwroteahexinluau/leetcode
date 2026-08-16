/* https://leetcode.com/problems/fibonacci-number/description/
 * 509. Fibonacci Number
 *
 * Standard Approach:
 * We can use a dp approach to store the previous two Fibonacci values as we loop through
 * to num.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int fibnacciNum(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        int twoPrev = 0;
        int prev = 1;

        int sum = 0;
        for (int i = 2; i <= num; i++) {
            sum = twoPrev + prev;
            twoPrev = prev;
            prev = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 0;
        int c = 1;
        int d = 2;
        int e = 4;

        System.out.println(fibnacciNum(a));
        System.out.println(fibnacciNum(b));
        System.out.println(fibnacciNum(c));
        System.out.println(fibnacciNum(d));
        System.out.println(fibnacciNum(e));
    }
}
