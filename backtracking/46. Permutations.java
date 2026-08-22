/* https://leetcode.com/problems/permutations/description/
 * 46. Permutations
 *
 * Recursively Inserting Method:
 * We recursively insert nums[pos] into every position in the array list. We set the loop
 * to end at i <= current.size() because the number of possible insertion positions is
 * the number of elements + 1. Take {1, 2, 3} as the array. The possible insertion
 * positions are _1_2_3_, where _ represents an insertion position. So even though there 
 * are only 3 elements, we have to run the loop an additional time, so i <= 
 * current.size(). As we loop for each recursion call, pos represents the current index
 * in nums that we are adding. After we add to current, we recurse with pos + 1 and the 
 * new current, then remove from current. This way, we avoid current being mutated by
 * previous recursions. When the length of our permutation reaches nums.length, it is
 * finished and we can copy it and add to our final array list.
 *
 * Time O(n * n!), Space O(n)
 * n! = the number of permutations, and n * n! because each completed permutation
 * requires copying n elements to the output. The space is O(n) because the recursive
 * stack goes one level deeper for each element in nums.
 *
 * Recursively Swapping Method:
 * We start with the fully built array nums. At every index, we swap that index with 
 * every other index from pos to the end of the array. After we have swapped that 
 * position, we recurse with the new array to the next index and fix the previous index's
 * value, leaving it unchanged for the rest of the recursion stack. As per usual
 * backtracking, we swap the elements back to avoid mutating the current array list. We
 * use pos to track what index we are currently at, and start the loop at i = pos to keep
 * the previous index's fixed.
 *
 * Time O(n * n!), Space O(n)
 * Same time and space complexity as the recursive insertion approach, but is less space
 * overhead because we can mutate the nums array directly instead of using an array list.
 */

import java.util.ArrayList;
import java.util.List;

class Solution {
    // insert method
    public static void recursion(int[] nums, int pos, List<Integer> current, List<List<Integer>> permsList) {
        if (current.size() == nums.length) {
            List<Integer> copy = new ArrayList<>(current);
            permsList.add(copy);
            return;
        }

        for (int i = 0; i <= current.size(); i++) {
            current.add(i, nums[pos]);
            recursion(nums, pos + 1, current, permsList);
            current.remove(i);
        }
    }
    // swapping method
    public static void recursionSwapping(int[] nums, int pos, List<List<Integer>> permsList) {
        if (pos == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) {
                permutation.add(num);
            }
            permsList.add(permutation);
            return;
        }

        for (int i = pos; i < nums.length; i++) {
            int temp = nums[pos];
            nums[pos] = nums[i];
            nums[i] = temp;
            //System.out.println("Swap : " + temp + " " + temp2);
            //System.out.println(current + " " + current.get(i) + " ");
            recursionSwapping(nums, pos + 1, permsList);
            nums[i] = nums[pos];
            nums[pos] = temp; 
        }
    }
    // insertion implementation
    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> permsList = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        recursion(nums, 0, current, permsList);
        return permsList;
    }
    // swapping implementation
    public static List<List<Integer>> permutations2(int[] nums) {
        List<List<Integer>> permsList = new ArrayList<>();

        recursionSwapping(nums, 0, permsList);
        return permsList;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {0, 1};
        int[] c = {1};

        System.out.println(permutations(a));
        System.out.println(permutations(b));
        System.out.println(permutations(c));

        System.out.println(permutations2(a));
        System.out.println(permutations2(b));
        System.out.println(permutations2(c));
    }
}
