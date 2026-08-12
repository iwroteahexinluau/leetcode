/* https://leetcode.com/problems/length-of-last-word/description/
 * 58. Length of Last Word
 *
 * It is a given that there is at least one word in string s. We can loop backwards
 * through the string until we find the last word. Then, we count the length of the word
 * until the next space or the loop ends.
 *
 * Time O(n), Space O(1)
 * n = number of characters
 */

class Solution {
    public static int lengthOfLastWord(String s) {
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++;
            } else if (count > 0) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String a = "Hello World";
        String b = "   fly me     to    the   moon ";
        String c = "luffy is still joyboy";
        String d = "Hello Worlddd a";

        System.out.println(lengthOfLastWord(a));
        System.out.println(lengthOfLastWord(b));
        System.out.println(lengthOfLastWord(c));
        System.out.println(lengthOfLastWord(d));
    }
}
