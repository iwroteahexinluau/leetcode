/* https://leetcode.com/problems/add-binary/description/
 * 67. Add Binary
 *
 * We loop through the strings right to left adding the digits together and keeping
 * track of the carry. The carry can be 0, 1, 2, or 3. Carry % 2 gives us the digit that
 * remains in that place, and carry / 2 brings over a 1 carry to the next position.
 * We are appending the new string left to right, so we have to reverse it before
 * returning.
 *
 * Time O(max(a.length(), b.length())), Space O(max(a.length(), b.length()))
 */

class Solution {
    public static String addBinary(String a, String b) {
        StringBuilder newNum = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) {
                if (a.charAt(i) == '1') {
                    carry++;
                }
                i--;
            }
            if (j >= 0) {
                if (b.charAt(j) == '1') {
                    carry++;
                }
                j--;
            }
            newNum.append(carry % 2);
            carry /= 2;
        }

        newNum.reverse();
        return newNum.toString();
    }


    public static void main(String[] args) {
        String a = "11", b = "1";
        String a1 = "1010", b1 = "1011";
        String a2 = "1", b2 = "0";
        String a3 = "1010", b3 = "11";

        System.out.println(addBinary(a, b));
        System.out.println(addBinary(a1, b1));
        System.out.println(addBinary(a2, b2));
        System.out.println(addBinary(a3, b3));
    }
}
