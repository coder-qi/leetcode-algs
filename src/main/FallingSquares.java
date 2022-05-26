import java.util.ArrayList;
import java.util.List;

import util.ArrayUtils;

/**
 * 699. 掉落的方块：https://leetcode.cn/problems/falling-squares/
 */
public class FallingSquares {

    public static List<Integer> fallingSquares(int[][] positions) {
        List<Integer> heights = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int left1 = positions[i][0], right1 = left1 + positions[i][1];
            int height = positions[i][1];
            for (int j = 0; j < i; j++) {
                int left2 = positions[j][0], right2 = left2 + positions[j][1];
                if (left2 < right1 && right2 > left1) {
                    height = Math.max(height, heights.get(j) + positions[i][1]);
                }
            }
            heights.add(height);
        }
        for (int i = 1; i < heights.size(); i++) {
            heights.set(i, Math.max(heights.get(i), heights.get(i - 1)));
        }
        return heights;
    }

    public static void main(String[] args) {
        System.out.println(fallingSquares(ArrayUtils.matrix("[[1,2],[2,3],[6,1]]"))); // [2, 5, 5]
        System.out.println(fallingSquares(ArrayUtils.matrix("[[100, 100], [200, 100]]"))); // [100, 100]
    }

}
