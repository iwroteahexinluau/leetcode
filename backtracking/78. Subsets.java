/* https://leetcode.com/problems/subsets/description/
 * 78. Subsets
 *
 * We can solve this problem using recursive backtracking. For every number, there are
 * exactly two choices, we can include the number or exclude it. So we iterate through
 * the length of the array, choosing to add nums[pos] and recurse, or choosing to exclude
 * nums[pos] and recurse. When the position reaches the end of the array, we end the
 * recursive loop. When we append the array to results, we copy to avoid the reference
 * getting mutated.
 *
 * Time O(n * 2^n), Space O(n)
 * There are 2^n possible subsets, because for each number we have two choices, include
 * or exclude it. When we construct a new array list to copy current for every subset,
 * it can be up to O(n) elements.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void recursion(int[] nums, List<List<Integer>> results, List<Integer> current, int pos) {
        if (pos == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[pos]); // adds nums[pos]
        recursion(nums, results, current, pos + 1); // recurse with the number
        current.remove(current.size() - 1); // removes the last added value
        recursion(nums, results, current, pos + 1); // recurse without the number
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> empty = new ArrayList<>();
        recursion(nums, results, empty, 0);

        return results;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {0};

        System.out.println(subsets(a));
        System.out.println(subsets(b));
    }
}
