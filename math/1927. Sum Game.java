/* https://leetcode.com/problems/sum-game/description/
 * 1927. Sum Game
 *
 * By observing simulations of the game, we can infer that Alice wins for a vast majority
 * of the scenarios. If the number of turns is odd, Alice can always make the last move
 * to make the sum uneven. If the number of turns on both sides is the same and the sum
 * is not the same, Alice can always add 9 to the bigger side. There are only two
 * conditions where Bob can win. If the number of turns on both sides is the same, and
 * the sum on both sides is the same, Bob can always match the move Alice makes. Lastly,
 * the only scenario that is left is there is an even number of turns, the sum is not
 * equal, and the turns remaining on one side will be in increments of 2 because the
 * length of num is even length. So the possible turns left on one side can be 2, 4, 6, 8
 * and so on. From observing when there are 2 turns left on one side, we can see that
 * if the sum is greater on the side that has the turns, Alice will always win, so the
 * larger sum must be on the other side of the turns. If the difference in sums is < 9, 
 * Alice can add 9 and will always win. If the difference in sums is > 9, Alice can add 0
 * and always win. The only scenario where Bob will win, is if the difference in sums is
 * exactly 9, because no matter what Alice adds, Bob can add the complement to fill the
 * difference. If we look at if there are 4 turns left on one side, we can see the same
 * thing; Bob will only win if the sum of the side without the terms has a difference of
 * exactly 18 with the side with the turns.
 *
 * So there are only two scenarios where Bob will win. If the difference in sums is zero
 * and the number of turns on both sides is even and if the difference in sums is
 * 9 * (moveDifference / 2) with the larger sum being on the side with no turns.
 *
 * We can combine this into a joint statement of when Bob wins with
 * 2 * (leftSum - rightSum) == 9 * (rightMoves - leftMoves)
 * If sums are even and moves are even, 0 == 0, Bob will win. If the leftSum - rightSum
 * == 9, then Bob can only win if rightMoves - leftMoves == 2, which is correct. This
 * also handles the case of rightSum > leftSum, because then the opposite side rightMoves 
 * - leftMoves will also be negative and correctly track if Bob wins.
 *
 * Time O(n), Space O(1)
 */

class Solution {
    public static boolean sumGame(String num) {
        int leftSum = 0, rightSum = 0;
        int leftMoves = 0, rightMoves = 0;
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) == '?') {
                leftMoves++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
            if (num.charAt(num.length() - i - 1) == '?') {
                rightMoves++;
            } else {
                rightSum += num.charAt(num.length() - i - 1) - '0';
            }
        }
        // Use != because we want to return true when Bob does not win
        return 2 * (leftSum - rightSum) != 9 * (rightMoves - leftMoves);
        
    }

    public static void main(String[] args) {
        String a = "5023";
        String b = "25??";
        String c = "?3295???";
        String d = "91??";
        String e = "09??";
        String f = "09";

        System.out.println(sumGame(a));
        System.out.println(sumGame(b));
        System.out.println(sumGame(c));
        System.out.println(sumGame(d));
        System.out.println(sumGame(e));
        System.out.println(sumGame(f));
    }
}
