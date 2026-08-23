/* https://leetcode.com/problems/partition-labels/description/
 * 763. Partition Labels
 *
 * We want to partition the string so that each letter appears in only one part. To do
 * this, we can track the last seen index of each character using a frequency array.
 * Then, we loop through the string again using two pointers to keep track of the current
 * window. If a character in the window has a last seen index that comes after the end
 * pointer, we extend the end pointer to the new last seen index. Once i == end, we know
 * that every character in the window will not appear in the string anymore, so we can
 * add the window to the array list.
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
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex[s.charAt(i) - 'a']);
            
            if (i == end) {
                partitions.add(end - start + 1);
                start = i + 1;
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
