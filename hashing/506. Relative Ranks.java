/* https://leetcode.com/problems/relative-ranks/description/
 * 506. Relative Ranks
 *
 * Initial Approach:
 * We can put every score and and its index into a hash map and then sort the array. We
 * loop backwards through the array getting the highest to lowest score and looking up
 * that index in the hash map, setting that index in placements to the appropriate rank.
 *
 * Time O(n * log n), Space O(n)
 *
 * Optimal Approach:
 * We find the max value in the array and then create an array with that size + 1 so each
 * score can be used directly as an index. Then we loop through the array again storing
 * the score as the index and the index as the value, score2[score[i]] = i + 1. We use
 * i + 1 because 0 is being used for the default value, and we still want to put in index
 * 0. Then we loop backwards through the second array from highest to lowest skipping any
 * zeroes visiting each score in descending order.
 *
 * Time O(n + m), Space O(m)
 * n = length of score array, m = max score
 */

import java.util.HashMap;
import java.util.Arrays;

class Solution {
    // initial approach
    public static String[] relativeRanks(int[] score) {
        String[] placements = new String[score.length];
        HashMap<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            seen.put(score[i], i);
        }
        Arrays.sort(score);
        int count = 1;
        for (int i = score.length - 1; i >= 0; i--) {
            int index = seen.get(score[i]);
            if (i == score.length - 1) {
                placements[index] = "Gold Medal";
            } else if (i == score.length - 2) {
                placements[index] = "Silver Medal";
            } else if (i == score.length - 3) {
                placements[index] = "Bronze Medal";
            } else {
                placements[index] = Integer.toString(count);
            }
            count++;
        }
        return placements;
    }
    // optimal approach
    public static String[] optimalRelativeRanks(int[] score) {
        int max = Integer.MIN_VALUE;
        int n = score.length;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, score[i]);
        }
        int[] score2 = new int[max + 1];
        for (int i = 0; i < n; i++) {
            score2[score[i]] = i + 1;
        }
        String[] placements = new String[n];
        int count = 1;
        for (int i = max; i >= 0; i--) {
            if (score2[i] == 0) {
                continue;
            }
            int index = score2[i] - 1;
            if (count == 1) {
                placements[index] = "Gold Medal";
            } else if (count == 2) {
                placements[index] = "Silver Medal";
            } else if (count == 3) {
                placements[index] = "Bronze Medal";
            } else {
                placements[index] = Integer.toString(count);
            }
            count++;
        }
        return placements;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};
        int[] b = {10, 3, 8, 9, 4};

        System.out.println(Arrays.toString(relativeRanks(a.clone())));
        System.out.println(Arrays.toString(relativeRanks(b.clone())));

        System.out.println(Arrays.toString(optimalRelativeRanks(a.clone())));
        System.out.println(Arrays.toString(optimalRelativeRanks(b.clone())));
    }
}
