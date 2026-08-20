/* https://leetcode.com/problems/multiply-strings/description/
 * 43. Multiply Strings
 *
 * To multiply the strings num1 and num2 together without converting to integer, we
 * multiply every digit in num1 with every digit in num2. The product of an m digit
 * number and an n digit number has either m + n digits, or m + n - 1 digits. Knowing
 * this, we can create an integer array to hold the values of each place as we multiply
 * the digits to keep track of running product and if we need to carry. We loop backwards
 * through the two numbers, multiplying each digit with each digit. As we multiply the
 * digits, i + j + 1 gives us the place, and i + j gives us the place that the carry will
 * go into if there is one. We put the second digit with % 10 into the i + j + 1 place,
 * and the first digit into i + j. We do not have to check if the position i + j has a
 * carry because we will always revisit every position excluding the index 0 place, which
 * is guaranteed to be a single digit at most. Lastly, we loop through the array and
 * build the final product string. Since the number is either m + n or m + n - 1 digits,
 * there can be at most one leading zero.
 *
 * Time O(m * n), Space O(m + n)
 * m = number of digits in num1, n = number of digits in num2
 */

class Solution {
    public static String multiplyStrings(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int num1Length = num1.length();
        int num2Length = num2.length();
        int[] product = new int[num1Length + num2Length];
        for (int i = num2Length - 1; i >= 0; i--) {
            // characters are stored in unicode so we have to subtract 0 to get the actual integer value
            int num2Digit = num2.charAt(i) - '0';
            for (int j = num1Length - 1; j >= 0; j--) {
                int num1Digit = num1.charAt(j) - '0';
                int multiply = num1Digit * num2Digit + product[i + j + 1];
                product[i + j + 1] = multiply % 10;
                product[i + j] += multiply / 10;
            }
        }
        StringBuilder result = new StringBuilder();
        // check if there is a leading zero
        int start = 0;
        if (product[0] == 0) {
            start = 1;
        }
        for (int i = start; i < product.length; i++) {
            result.append(product[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a1 = "2", a2 = "3";
        String b1 = "123", b2 = "456";
        String c1 = "2", c2 = "12";
        String d1 = "0", d2 = "2";
        String e1 = "139", e2 = "99";

        System.out.println(multiplyStrings(a1, a2));
        System.out.println(multiplyStrings(b1, b2));
        System.out.println(multiplyStrings(c1, c2));
        System.out.println(multiplyStrings(d1, d2));
        System.out.println(multiplyStrings(e1, e2));
    }
}
