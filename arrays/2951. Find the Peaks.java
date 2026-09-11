/* https://leetcode.com/problems/find-the-peaks/description/
 * 2951. Find the Peaks
 *
 * We can loop through and check if each element is a peak (greater than the previous
 * and next element).
 *
 * Time O(n), Space O(1)
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    public static List<Integer> findThePeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
            }
        }
        return peaks;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 4};
        int[] b = {1, 4, 3, 8, 5};

        System.out.println(findThePeaks(a));
        System.out.println(findThePeaks(b));
    }
}
