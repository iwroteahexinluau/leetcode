/* https://leetcode.com/problems/fibonacci-number/description/
 * 509. Fibonacci Number
 *
 * Standard Approach:
 * We can use a dp approach to store the previous two Fibonacci values as we loop through
 * to num.
 *
 * Time O(n), Space O(1)
 *
 * Alternate Approach:
 * We can use recursion to split fibonacci(n) into fibonacci(n - 1) + fibonacci(n - 2)
 * until n = 1 or n = 0.
 *
 * Time O(2^n), Space O(n)
 *
 * When calculating large values of n with the fibonacci sequence, there is a method
 * called fast doubling that can compute fibonacci in time O(log n).
 */

class Solution {
    // dp approach
    public static int fibonacciNum(int num) {
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

    // recursive approach
    public static int recursiveFibonacciNum(int num) {
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        return recursiveFibonacciNum(num - 1) + recursiveFibonacciNum(num - 2);
    }
            
    public static void main(String[] args) {
        int a = 3;
        int b = 0;
        int c = 1;
        int d = 2;
        int e = 4;

        System.out.println(fibonacciNum(a));
        System.out.println(fibonacciNum(b));
        System.out.println(fibonacciNum(c));
        System.out.println(fibonacciNum(d));
        System.out.println(fibonacciNum(e));

        System.out.println(recursiveFibonacciNum(a));
        System.out.println(recursiveFibonacciNum(b));
        System.out.println(recursiveFibonacciNum(c));
        System.out.println(recursiveFibonacciNum(d));
        System.out.println(recursiveFibonacciNum(e));
    }
}
