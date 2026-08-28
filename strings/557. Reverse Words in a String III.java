/* https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
 * 557. Reverse Words in a String III
 *
 * We can split the string into words with .split(), then reverse each word and append it
 * to a new string. If the first word has been placed into the reversed string, we can
 * append the space before every next word that gets appended.
 *
 * Time O(n), Space O(n)
 */

class Solution {
    public static String reverseString(String s) {
        StringBuilder reversed = new StringBuilder();
        for (String word : s.split(" ")) {
            if (reversed.length() > 0) {
                reversed.append(' ');
            }
            reversed.append(new StringBuilder(word).reverse());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        String a = "Let's take a LeetCode contest";
        String b = "Mr Ding";

        System.out.println(reverseString(a));
        System.out.println(reverseString(b));
    }
}
