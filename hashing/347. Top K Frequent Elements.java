/* https://leetcode.com/problems/top-k-frequent-elements/description/
 * 347. Top K Frequent Elements
 *
 * The approach to this problem is creating a map (using an array) with the frequency of
 * how many times a number appears as the key, and the number itself as the value. That
 * way we can loop from highest to lowest in keys to get the k most frequent elements. To
 * do this, we first put every number with its frequency into a hash map with the number
 * being the key and the frequency being the value. Then we create an array of length
 * nums.length + 1, that will represent our map, and because numbers can have the same
 * frequencies, we have the array hold an array list that will hold the numbers at that
 * frequency. So we iterate through the hash map adding to the array with the frequency
 * as the key, and the number as the value. Lastly, we loop from maxFreq downwards in the
 * array to get the k most frequent elements.
 *
 * Time O(n), Space O(n)
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public static int[] topFrequentElements(int[] nums, int k) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            seen.put(nums[i], seen.getOrDefault(nums[i], 0) + 1);
            maxFreq = Math.max(maxFreq, seen.get(nums[i]));
        }
        // nums.length + 1 because the frequency can go as high as nums.length
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : seen.entrySet()) {
            if(bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        int[] results = new int[k];
        int j = 0;
        for (int i = maxFreq; i > 0 && j < k; i--) {
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    results[j] = num;
                    j++;
                    if (j == k) {
                        break;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3};
        int[] b = {1};
        int[] c = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
        int k1 = 1, k2 = 2;

        System.out.println(Arrays.toString(topFrequentElements(a, k2)));
        System.out.println(Arrays.toString(topFrequentElements(b, k1)));
        System.out.println(Arrays.toString(topFrequentElements(c, k2)));
    }
}
