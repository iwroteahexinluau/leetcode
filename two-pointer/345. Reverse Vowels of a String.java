/* https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * 345. Reverse Vowels of a String
 *
 * Initial Approach:
 * We can loop through the string putting all the vowels into a stack, then loop through
 * the string again checking for vowels. If we find a vowel, we replace it with the
 * character from the top of the stack, building a string with its vowels reversed.
 *
 * Time O(n), Space O(n)
 *
 * Optimized Approach:
 * We can use two pointers starting at the start and end of the string and work inwards
 * finding pairs of vowels until the pointers meet. When a pair of vowels is found, we
 * swap the two characters.
 *
 * Time O(n), Space O(n)
 */

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c =='U') {
            return true;
        } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }
    // initial approach
    public static String reverseVowels(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }
        // there is one or less vowels so the string returns unchanged
        if (stack.size() <= 1) {
            return s;
        }
        StringBuilder reversedVowels = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                reversedVowels.append(stack.pop());
            } else {
                reversedVowels.append(s.charAt(i));
            }
        }
        return reversedVowels.toString();
    }
    // optimized approach
    public static String opitimizedReverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while(i < j) {
            while (i < j && !isVowel(chars[i])) {
                i++;
            }
            while (i < j && !isVowel(chars[j])) {
                j--;
            }
            if (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String a = "IceCreAm";
        String b = "leetcode";
        String c = "test";

        System.out.println(reverseVowels(a));
        System.out.println(reverseVowels(b));
        System.out.println(reverseVowels(c));

        System.out.println(opitimizedReverseVowels(a));
        System.out.println(opitimizedReverseVowels(b));
        System.out.println(opitimizedReverseVowels(c));
    }
}
