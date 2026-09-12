/* https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 349. Intersection of Two Arrays
 *
 * We can use two hash sets. We put the values of nums1 into the first hash set and then
 * add every value in nums2 that is in the first set to the intersecting set.
 *
 * Time O(n + m), Space O(n + m)
 * n = nums1.length, m = nums2.length
 */

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public static int[] intersectionOfTwoArrays(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> intersections = new HashSet<>();
        for (int x : nums1) {
            set1.add(x);
        }
        for (int x : nums2) {
            if (set1.contains(x)) {
                intersections.add(x);
            }
        }
        int[] results = new int[intersections.size()];
        int i = 0;
        for (int x : intersections) {
            results[i] = x;
            i++;
        }
        return results;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 2, 1};
        int[] b1 = {2, 2};
        int[] a2 = {4, 9, 5};
        int[] b2 = {9, 4, 9, 8, 4};

        System.out.println(Arrays.toString(intersectionOfTwoArrays(a1, b1)));
        System.out.println(Arrays.toString(intersectionOfTwoArrays(a2, b2)));
    }
}
