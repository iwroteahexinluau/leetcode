/* https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
 * 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * We can using a sliding window of length k and track the number of vowels inside the
 * window at any given point. As we loop through the string, we remove the character at
 * the previous left pointer of the window, shifting the window to the right by one 
 * position and adding the new character at the right pointer. We check at every position
 * if there is a new maximum number of vowel letters in the window.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public static int maxNumberOfVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        int max = count;
        for (int i = 1; i < s.length() - k + 1; i++) {
            if (isVowel(s.charAt(i - 1))) {
                count--;
            }
            if (isVowel(s.charAt(i + k - 1))) {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "abciiidef";
        String b = "aeiou";
        String c = "leetcode";
        String d = "a";
        int k1 = 1, k2 = 2, k3 = 3;

        System.out.println(maxNumberOfVowels(a, k3));
        System.out.println(maxNumberOfVowels(b, k2));
        System.out.println(maxNumberOfVowels(c, k3));
        System.out.println(maxNumberOfVowels(d, k1));
    }
}
