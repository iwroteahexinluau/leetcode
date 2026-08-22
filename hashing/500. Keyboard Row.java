/* https://leetcode.com/problems/keyboard-row/description/
 * 500. Keyboard Row
 *
 * We loop through each word, assigning the row based on the first character. We then
 * check if every other character in the word by turning it to lowercase and using
 * indexOf(). As soon as the character is not in the row, we break. If we make it to the
 * end of the word and it is valid, we add to the final array. We could alternatively
 * use a hash map to store and lookup the row characters.
 *
 * Time O(m * n), Space O(n)
 * m = average length of the words, n = length of the string words array
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Solution {
    public static String[] keyboardRow(String[] words) {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";
        List<String> sameRowWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // if word is one letter, it will always be in same row
            if (word.length() == 1) {
                sameRowWords.add(word);
                continue;
            }
            String row = "";
            char letter = Character.toLowerCase(word.charAt(0));
            if (firstRow.indexOf(letter) != -1) {
                row = firstRow;
            } else if (secondRow.indexOf(letter) != -1) {
                row = secondRow;
            } else {
                row = thirdRow;
            }
            for (int j = 1; j < word.length(); j++) {
                letter = Character.toLowerCase(word.charAt(j));
                if (row.indexOf(letter) == -1) {
                    break;
                }
                if (j == word.length() - 1) {
                    sameRowWords.add(word);
                }
            }
        }
        /* toArray(new String[0]) first creates an array of size 0, then creates a new 
         * array of size sameRowWords. toArray(String[] :: new) directly creates the
         * array of the required size, same as doing toArray(new String[sameRowWords.size()]).
         */
        return sameRowWords.toArray(String[] :: new);
    }

    public static void main(String[] args) {
        String[] a = {"Hello", "Alaska", "Dad", "Peace"};
        String[] b = {"omk"};
        String[] c = {"adsdf", "sfd"};
        String[] d = {"asd", "asd", "ase"};
        String[] e = {"DAD"};
        String[] f = {"D", "test"};

        System.out.println(Arrays.toString(keyboardRow(a)));
        System.out.println(Arrays.toString(keyboardRow(b)));
        System.out.println(Arrays.toString(keyboardRow(c)));
        System.out.println(Arrays.toString(keyboardRow(d)));
        System.out.println(Arrays.toString(keyboardRow(e)));
        System.out.println(Arrays.toString(keyboardRow(f)));
    }
}
