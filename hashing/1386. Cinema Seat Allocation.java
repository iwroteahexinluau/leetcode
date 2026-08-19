/* https://leetcode.com/problems/cinema-seat-allocation/description/
 * 1386. Cinema Seat Allocation
 *
 * There are only 3 possibile four person groups.
 * [2, 3, 4, 5]
 * [4, 5, 6, 7]
 * [6, 7, 8, 9]
 * We can loop through the reserved seats building a hash map for the row and a boolean
 * array that contains whether the respective group is valid. We check each reserved seat
 * and set the group it is in to false in the array. After we are finished checking every
 * reserved seat, we loop through the hash map and subtract from the total that would be
 * if no seats were reserved at all, n * 2. For each row, if both the first and third 
 * groups are valid, 2 groups can be seated. If at least one group is valid, then one
 * group can be seated, otherwise no groups are valid and therefore no groups can be
 * seated.
 *
 * Time O(n), Space O(n)
 */

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int cinemaSeatAllocation(int n, int[][] reservedSeats) {
        HashMap<Integer, boolean[]> seen = new HashMap<>();
        int possibilities = n * 2;

        for (int i = 0; i < reservedSeats.length; i++) {
            int[] reservation = reservedSeats[i];
            int row = reservation[0];
            if (!seen.containsKey(row)) {
                boolean[] possibleGroups = {true, true, true};
                seen.put(reservation[0], possibleGroups);
            }

            int seat = reservation[1];
            boolean[] possibleGroups = seen.get(row);
            if (seat == 2 || seat == 3) {
                possibleGroups[0] = false;
            } else if (seat == 4 || seat == 5) {
                possibleGroups[0] = false;
                possibleGroups[1] = false;
            } else if (seat == 6 || seat == 7) {
                possibleGroups[1] = false;
                possibleGroups[2] = false;
            } else if (seat == 8 || seat == 9) {
                possibleGroups[2] = false;
            }
            seen.replace(row, possibleGroups);
        }

        for (Map.Entry<Integer, boolean[]> entry : seen.entrySet()) {
            boolean[] groups = entry.getValue();
            if (!(groups[0] && groups[2])) {
                if (groups[0] || groups[1] || groups[2]) {
                    possibilities--;
                } else {
                    possibilities -= 2;
                }
            }
        }
        return possibilities;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {1, 3}, {1, 8}, {2, 6}, {3, 1}, {3, 10}};
        int[][] b = {{2, 1}, {1, 8}, {2, 6}};
        int[][] c = {{4, 3}, {1, 4}, {4, 6}, {1, 7}};
        int[][] d = {{1, 2}, {1, 7}};
        int[][] e = {{1, 2}, {1, 4}};
        int n1 = 3, n2 = 2, n3 = 4, n4 = 1;

        System.out.println(cinemaSeatAllocation(n1, a));
        System.out.println(cinemaSeatAllocation(n2, b));
        System.out.println(cinemaSeatAllocation(n3, c));
        System.out.println(cinemaSeatAllocation(n4, d));
        System.out.println(cinemaSeatAllocation(n4, e));
    }
}
