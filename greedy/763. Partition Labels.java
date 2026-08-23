/* https://leetcode.com/problems/partition-labels/description/
 * 763. Partition Labels
 *
 * We want to partition the string so that each letter appears in only one part. To do
 * this, we can track the last seen index of each character using a frequency array.
 * Then, we loop through the string again building a sliding window where the right
 * pointer = the last seen index of that character. Then we move the left pointer to
 * right checking to see if all of the characters inside of the window have their last
 * seen index within that window. If a character inside the window has a last seen index
 * after right, we shift the right pointer to the new last seen index. If left reaches
 * right, then all characters in that window do not appear later in the string and we
 * can make the partition keeping track of the original start of the window with j.
 *
 * Time O(n), Space O(1)
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        int right = 0;
        int j = 0;
        right = lastIndex[s.charAt(0) - 'a'];
        while (right < s.length()) {
            int left = j;
            while (left < right) {
                left++;
                if (lastIndex[s.charAt(left) - 'a'] > right) {
                    right = lastIndex[s.charAt(left) - 'a'];
                }
            }
            partitions.add(right - j + 1);
            right++;
            j = right;
            if (right < s.length()) {
                right = lastIndex[s.charAt(right) - 'a'];
            }
        }
        return partitions;
    }

    public static void main(String[] args) {
        String a = "ababcbacadefegdehijhklij";
        String b = "eccbbbbdec";

        System.out.println(partitionLabels(a));
        System.out.println(partitionLabels(b));
    }
}
