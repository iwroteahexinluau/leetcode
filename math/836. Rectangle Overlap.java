/* https://leetcode.com/problems/rectangle-overlap/description/
 * 836. Rectangle Overlap
 *
 * We can approach this by checking if the two rectangles are guaranteed to not overlap.
 * The rectangles do not overlap if the first rectangle is completely to the right, left,
 * above, or below the second rectangle.
 *
 * Time O(1), Space O(1)
 */

class Solution {
    public static boolean rectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0], y1 = rec1[1];
        int x2 = rec1[2], y2 = rec1[3];
        if (x1 >= rec2[2] || y1 >= rec2[3]) {
            return false;
        }
        if (x2 <= rec2[0] || y2 <= rec2[1]) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] a1 = {0, 0, 2, 2};
        int[] b1 = {1, 1, 3, 3};
        int[] a2 = {0, 0, 1, 1};
        int[] b2 = {1, 0, 2, 1};
        int[] a3 = {0, 0, 1, 1};
        int[] b3 = {2, 2, 3, 3};
        int[] a4 = {5, 15, 8, 18};
        int[] b4 = {0, 3, 7, 9};
        int[] a5 = {7, 8, 13, 15};
        int[] b5 = {10, 8, 12, 20};

        System.out.println(rectangleOverlap(a1, b1));
        System.out.println(rectangleOverlap(a2, b2));
        System.out.println(rectangleOverlap(a3, b3));
        System.out.println(rectangleOverlap(a4, b4));
        System.out.println(rectangleOverlap(a5, b5));
    }
}
