/* https://leetcode.com/problems/smallest-missing-multiple-of-k/description/
 * 3718. Smallest Missing Multiple of K
 *
 * We add every num in array nums to a set, then start at the lowest multiple of k
 * checking if the set contains the multiple until it does not. Then we return the
 * missing multiple of k which will be the smallest.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashSet;

class Solution {
    public static int smallestMissingMultiple(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }
        int multiple = k;
        while (seen.contains(multiple)) {
            multiple += k;
        }
        return multiple;
    }

    public static void main(String[] args) {
        int[] a = {8, 2, 3, 4, 6};
        int[] b = {1, 4, 7, 10, 15};
        int k1 = 2, k2 = 5;

        System.out.println(smallestMissingMultiple(a, k1));
        System.out.println(smallestMissingMultiple(b, k2));
    }
}
