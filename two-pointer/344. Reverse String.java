/* https://leetcode.com/problems/reverse-string/description/
 * 344. Reverse String
 *
 * We can loop through the first half of the string array swapping the second half with
 * the first half. i < s.length / 2 gives us the correct stopping point because if it is
 * an odd number of characters, the middle character stays the same.
 *
 * Time O(n), Space O(1)
 */

import java.util.Arrays;

class Solution {
    public static char[] reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
        return s;
    }

    public static void main(String[] args) {
        char[] a = {'h', 'e', 'l', 'l', 'o'};
        char[] b = {'H', 'a', 'n', 'n', 'a', 'h'};

        System.out.println(Arrays.toString(reverseString(a)));
        System.out.println(Arrays.toString(reverseString(b)));
    }
}
