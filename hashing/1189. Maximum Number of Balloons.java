/* https://leetcode.com/problems/maximum-number-of-balloons/description/
 * 1189. Maximum Number of Balloons
 *
 * We can keep count of each letter in text that is in the word balloon. Using a switch
 * statement we can increment the count of that letter. Then, once we have finished
 * looping through the string, we take the minimum of all the counts, with 'l' and 'o'
 * letter counts being divided in 2.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static int maxNumOfBalloons(String text) {
        // if length < 7, not possible
        if (text.length() < 7) {
            return 0;
        }
        int b = 0, a = 0, l = 0, o = 0, n = 0;
        for (int i = 0; i < text.length(); i++) {
            char letter = text.charAt(i);
            switch (letter) {
                case 'b': b++; break;
                case 'a': a++; break;
                case 'l': l++; break;
                case 'o': o++; break;
                case 'n': n++; break;
            }
        }
        int minimum = Math.min(a, b);
        minimum = Math.min(minimum, Math.min(l / 2, o / 2));
        return Math.min(minimum, n);
    }

    public static void main(String[] args) {
        String a = "nlaebolko";
        String b = "loonbalxballpoon";
        String c = "leetcode";

        System.out.println(maxNumOfBalloons(a));
        System.out.println(maxNumOfBalloons(b));
        System.out.println(maxNumOfBalloons(c));
    }
}
