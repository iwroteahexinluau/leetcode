/* https://leetcode.com/problems/subsets-ii/description/
 * 90. Subsets II
 *
 * We can use recursive backtracking to create all of the possible subsets of the array
 * nums. As we loop through nums keeping track of our current index with pos, we either
 * choose to add the number to the subset or skip it. When pos == nums.length, we add a
 * copy of the subset to the final results list and end the recursion loop. To make sure
 * that we do not contain duplicate subsets in results, first we sort the array nums.
 * Sorting allows us to check if the previous value is the same, therefore finding a
 * duplicate number. We only care about finding a duplicate number on the exclude branch,
 * because duplicate subsets only occur if we exclude a number, then include it later. So
 * after we exclude a number, we skip the exclude branch until nums[pos] != nums[pos - 1]
 * or pos == nums.length. If pos == nums.length, we can safely exclude the number because
 * we are not going to be including the duplicate number again after.
 *
 * Time O(n * 2^n), Space O(n)
 * 2^n because at every recursion level, we choose either to to add nums[pos] or skip
 * nums[pos].
 *
 * Alternatively, since the array is sorted we could use a set to track the seen subsets,
 * and if the subset has already been seen when it finishes, we do not add it to results.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public static void recursion(int[] nums, int pos, List<Integer> current, List<List<Integer>> results) {
       if (pos == nums.length) {
           List<Integer> copy = new ArrayList<>(current);
           results.add(copy);
           return;
       }   
       current.add(nums[pos]);
       recursion(nums, pos + 1, current, results);
       pos++;
       while (pos < nums.length && nums[pos] == nums[pos - 1]) {
            pos++;
       }
       current.remove(current.size() - 1);
       recursion(nums, pos, current, results);
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        recursion(nums, 0, current,  results);
        return results;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        int[] b = {0};
        int[] c = {3, 2, 1};
        int[] d = {1, 2, 1};

        System.out.println(subsets2(a));
        System.out.println(subsets2(b));
        System.out.println(subsets2(c));
        System.out.println(subsets2(d));
    }
}
