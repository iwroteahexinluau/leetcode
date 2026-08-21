/* https://leetcode.com/problems/sort-vowels-in-a-string/description/
 * 2785. Sort Vowels in a String
 *
 * Since there are only 10 vowels including uppercase and lowercase, we can use an array
 * to track the frequency of each value as we loop through the string. Then, we loop
 * through the string again building the new string. If we come across a vowel, we choose
 * the lowest ASCII value vowel from the frequency array and append it.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static boolean isVowel(char c) {
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }

    public static String sortVowels(String s) {
        int[] vowels = new int[10];
        int count = 0;                           // if no vowels, we return early
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            switch (letter) {
                case 'A': vowels[0]++; count++; break;
                case 'E': vowels[1]++; count++; break;
                case 'I': vowels[2]++; count++; break;
                case 'O': vowels[3]++; count++; break;
                case 'U': vowels[4]++; count++; break;
                case 'a': vowels[5]++; count++; break;
                case 'e': vowels[6]++; count++; break;
                case 'i': vowels[7]++; count++; break;
                case 'o': vowels[8]++; count++; break;
                case 'u': vowels[9]++; count++; break;
            }
        }
        if (count == 0) {
            return s;
        }
        int j = 0;
        StringBuilder sortedWord = new StringBuilder();
        String order = "AEIOUaeiou";       // index order to find which vowel to append
        for (int i = 0; i < s.length(); i++) {
            // find the next vowel to insert
            while (j < vowels.length && vowels[j] == 0) {
                j++;
            }
            if (isVowel(s.charAt(i))) {
                sortedWord.append(order.charAt(j));
                vowels[j]--;
            } else {
                sortedWord.append(s.charAt(i));
            }
        }
        return sortedWord.toString();
    }

    public static void main(String[] args) {
        String a = "lEetcOde";
        String b = "lYmpH";

        System.out.println(sortVowels(a));
        System.out.println(sortVowels(b));
    }
}
