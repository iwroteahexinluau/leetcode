/* https://leetcode.com/problems/jewels-and-stones/description/
 * 771. Jewels and Stones
 *
 * We can loop through jewels and build a boolean lookup array for each character. Then
 * we loop through stones and check if it's in the array, incrementing count if
 * it is.
 *
 * Time O(n), Space O(1)
 *
 * Alternatively we can use indexOf() instead of building a frequency array, but indexOf
 * checks each character one by one until it finds a match and is time O(j), j = letters
 * in jewels. We could also use a set.
 */

class Solution {
    public static int jewelsAndStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[52];
        for (int i = 0; i < jewels.length(); i++) {
            char letter = jewels.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                isJewel[letter - 'a'] = true;
            } else {
                isJewel[letter - 'A' + 26] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            char letter = stones.charAt(i);
            if (letter >= 'a' && letter <= 'z') {
                if (isJewel[letter - 'a']) {
                    count++;
                }
            } else {
                if (isJewel[letter - 'A' + 26]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String j1 = "aA", s1= "aAAbbbb";
        String j2 = "z", s2 = "ZZ";

        System.out.println(jewelsAndStones(j1, s1));
        System.out.println(jewelsAndStones(j2, s2));
    }
}
