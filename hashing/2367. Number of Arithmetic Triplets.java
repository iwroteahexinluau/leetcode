/* https://leetcode.com/problems/number-of-arithmetic-triplets/description/
 * 2367. Number of Arithmetic Triplets
 *
 * It is a given that nums is a strictly increasing array. Similar to two sum, a
 * triplet will be x, x - diff, x - 2 * diff. As we loop through nums, we can check
 * if the two previous numbers in the triplet exist.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashSet;

class Solution {
    public static int numTriplets(int[] nums, int diff) {
        HashSet<Integer> seen = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int twoPrev = nums[i] - 2 * diff;
            int prev = nums[i] - diff;
            if (seen.contains(prev) && seen.contains(twoPrev)) {
                count++;
            }
            seen.add(nums[i]); // even if match is found, add to the hash set because it
                               // can be used by a later triplet
        }
        return count;
   }

    public static void main(String[] args) {
        int[] a = {0, 1, 4, 6, 7, 10};
        int[] b = {4, 5, 6, 7, 8, 9};
        int[] c = {1, 5, 6};
        int[] d = {1, 2, 3};
        int diffA = 3, diffB = 2, diffC = 1, diffD = 1;

        System.out.println(numTriplets(a, diffA));
        System.out.println(numTriplets(b, diffB));
        System.out.println(numTriplets(c, diffC));
        System.out.println(numTriplets(d, diffD));
    }
}
