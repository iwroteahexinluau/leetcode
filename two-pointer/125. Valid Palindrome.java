/* https://leetcode.com/problems/valid-palindrome/description/
 * 125. Valid Palindrome
 *
 * We use two pointers to check the left valid character with the right valid character.
 * If the character is not an alphanumeric character, we move the respective pointer
 * until both two pointers have an alphanumeric character. Then we compare the characters
 * at both pointers ignoring uppercase, and break if it is an invalid palindrome. If the
 * palindrome is still valid, we move both pointers inward.
 *
 * Time O(n), Space O(1)
 * n = number of characters
 */

class Solution {
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "A man, a plan, a canal: Panama";
        String b = "race a car";
        String c = " ";
        String d = "1p";
        String e = "12G21";

        System.out.println(validPalindrome(a));
        System.out.println(validPalindrome(b));
        System.out.println(validPalindrome(c));
        System.out.println(validPalindrome(d));
        System.out.println(validPalindrome(e));
    }
}
