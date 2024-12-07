/**
 * 1217. 玩筹码：https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 */
public class MinimumCostToMoveChipsToTheSamePosition {

    public static int minCostToMoveChips(int[] position) {
        int oddCount = 0, evenCount = 0;
        for (int i = 0; i < position.length; i++) {
            if (position[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        return Math.min(oddCount, evenCount);
    }

    public static void main(String[] args) {

    }

}
