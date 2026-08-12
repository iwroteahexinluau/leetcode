/* https://leetcode.com/problems/longest-consecutive-sequence/description/
 * 128. Longest Consecutive Sequence
 *
 * First, we add all the numbers to a set. Then, we iterate through the set (to avoid
 * checking sequences on duplicate numbers), checking if the number is a valid starting
 * position for the longest sequence. A num is a valid starting position if num - 1 does
 * not exist in the array. Once we find a valid starting position, we count the sequence
 * until num + 1 doesn't exist in the array.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashSet;

class Solution {
    public static int longestConsecutiveSequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> seen = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            seen.add(nums[i]);
        }

        int longest = 0;
        for (int num : seen) {
            if (seen.contains(num - 1)) {
                continue;
            }
            int current = 0;
            while (seen.contains(num + 1)) {
                current++;
                num++;
            }
            longest = Math.max(longest, current);
        }
        return longest + 1;
    }

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        int[] b = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        int[] c = {1, 0, 1, 2};
        int[] d = {};
        int[] e = {5};

        System.out.println(longestConsecutiveSequence(a));
        System.out.println(longestConsecutiveSequence(b));
        System.out.println(longestConsecutiveSequence(c));
        System.out.println(longestConsecutiveSequence(d));
        System.out.println(longestConsecutiveSequence(e));
    }
}
