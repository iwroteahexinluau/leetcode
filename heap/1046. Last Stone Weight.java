/* https://leetcode.com/problems/last-stone-weight/description/
 * 1046. Last Stone Weight
 *
 * We can use a max heap to access the heaviest two stones. We first loop through the
 * array and add the values to the heap. Then we loop until there is one or zero stones
 * remaining, comparing the values of the two heaviest stones. If the two stones don't
 * equal each other, a stone with the difference in weight is added to the heap,
 * otherwise both stones are destroyed.
 *
 * Time O(n log n), Space O(n)
 * We are adding n values to the heap with .add(), so O(n log n)
 */

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }
        while (maxHeap.size() > 1) {
            int stoneY = maxHeap.poll();
            int stoneX = maxHeap.poll();
            if (stoneX != stoneY) {
                maxHeap.add(stoneY - stoneX);
            }
        }
        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {2, 7, 4, 1, 8, 1};
        int[] b = {1};
        int[] c = {2, 2};

        System.out.println(lastStoneWeight(a));
        System.out.println(lastStoneWeight(b));
        System.out.println(lastStoneWeight(c));
    }
}
