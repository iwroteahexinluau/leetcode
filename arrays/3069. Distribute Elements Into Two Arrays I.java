/* https://leetcode.com/problems/distribute-elements-into-two-arrays-i/description/
 * 3069. Distribute Elements Into Two Arrays I
 *
 * We create two arrays, putting nums[0] in arr1 and nums[1] in arr2. Then, we loop
 * through the rest of nums putting nums[i] into the array that has the bigger last
 * element. We use two pointers to keep track of where the last element is in arr1 and
 * arr2. Once we have finished looping through nums, we append arr2 to arr1.
 *
 * Time O(n), Space O(n)
 */

import java.util.Arrays;

class Solution {
    public static int[] distributeElements(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int i = 0;
        int j = 0;
        for (int k = 2; k < n; k++) {
            if (arr1[i] > arr2[j]) {
                arr1[i + 1] = nums[k];
                i++;
            } else {
                arr2[j + 1] = nums[k];
                j++;
            }
        }
        // reset the pointer in arr2
        j = 0;
        for (int k = i + 1; k < n; k++) {
            arr1[k] = arr2[j];
            j++;
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 3};
        int[] b = {5, 4, 3, 8};

        System.out.println(Arrays.toString(distributeElements(a)));
        System.out.println(Arrays.toString(distributeElements(b)));
    }
}
