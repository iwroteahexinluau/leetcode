/* https://leetcode.com/problems/check-divisibility-by-digit-sum-and-product/description/
 * 3622. Check Divisibility by Digit Sum and Product
 *
 * We can loop through each digit of n calculating the product and sum. Then we return
 * true if n is divisible by the sum + product.
 *
 * Time O(log n), Space O(1)
 * log n = number of digits in n
 */

class Solution {
    public static boolean checkDivisibility(int n) {
        int temp = n;
        int sum = 0, product = 1;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return n % (sum + product) == 0;
    }

    public static void main(String[] args) {
        int a = 99;
        int b = 23;
        int c = 1;

        System.out.println(checkDivisibility(a));
        System.out.println(checkDivisibility(b));
        System.out.println(checkDivisibility(c));
    }
}
