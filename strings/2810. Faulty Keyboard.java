/* https://leetcode.com/problems/faulty-keyboard/description/
 * 2810. Faulthy Keyboard
 *
 * Initial Approach:
 * We can loop through the string building a new string with string builder that consists
 * of all letters except for i. When the character i is found, we reverse the current
 * built string.
 *
 * Time O(n^2), Space O(n)
 * StringBuilder .reverse() is O(n), and there can be O(n) i characters
 *
 * Optimized Approach:
 * We can keep track of whether or not the string is reversed, and then add to the start
 * or end of the string accordingly. We can use a deque (double ended queue) to add to
 * both ends, then iterating through and building the final string. If reversed == true
 * at the end, we read from back to front to build the string.
 *
 * Time O(n), Space O(n)
 */

import java.util.Deque;
import java.util.Iterator;
import java.util.ArrayDeque;

class Solution {
    // initial approach
    public static String faultyKeyboard(String s) {
        StringBuilder faultyWord = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'i') {
                faultyWord.append(s.charAt(i));
            } else {
                faultyWord.reverse();
            }
        }
        return faultyWord.toString();
    }
    // optimized approach
    public static String optimizedFaultyKeyboard(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder faultyWord = new StringBuilder();
        boolean reversed = false;
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (letter != 'i') {
                if (!reversed) {
                    deque.addLast(letter);
                } else {
                    deque.addFirst(letter);
                }
            } else {
                reversed = !reversed;
            }
        }
        if (!reversed) {
            for (char c : deque) {
                faultyWord.append(c);
            }
        // if reversed == true, we read from back to front of the deque
        } else {
            Iterator<Character> iterator = deque.descendingIterator();
            while (iterator.hasNext()) {
                faultyWord.append(iterator.next());
            }
        }
        return faultyWord.toString();
    }

    public static void main(String[] args) {
        String a = "string";
        String b = "poiinter";

        System.out.println(faultyKeyboard(a));
        System.out.println(faultyKeyboard(b));

        System.out.println(optimizedFaultyKeyboard(a));
        System.out.println(optimizedFaultyKeyboard(b));
    }
}
