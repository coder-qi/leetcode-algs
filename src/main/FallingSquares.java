import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import util.ArrayUtils;

/**
 * 699. 掉落的方块：https://leetcode.cn/problems/falling-squares/
 */
public class FallingSquares {

    public static List<Integer> fallingSquares(int[][] positions) {
        int n = positions.length;
        List<Integer> heights = new ArrayList<>();
        TreeMap<Integer, Integer> heightMap = new TreeMap<>();
        heightMap.put(0, 0);
        for (int i = 0; i < n; i++) {
            int left = positions[i][0], right = left + positions[i][1] - 1;
            int sideLength = positions[i][1];
            int rHeight = heightMap.floorEntry(right + 1).getValue();

            // 第i块方块堆积的高度
            int height = 0;
            Map.Entry<Integer, Integer> lower;
            while ((lower = heightMap.floorEntry(right)) != null) {
                height = Math.max(height, lower.getValue());
                if (lower.getKey() >= left) {
                    heightMap.remove(lower.getKey()); // 清除[left, right]范围内的height
                }
                if (lower.getKey() <= left) {
                    break;
                }
            }
            height += sideLength;

            heightMap.put(left, height);
            if (!heightMap.containsKey(right + 1)) {
                heightMap.put(right + 1, rHeight);
            }
            heights.add(i > 0 ? Math.max(heights.get(i - 1), height) : height);
        }
        return heights;
    }

    public static void main(String[] args) {
        System.out.println(fallingSquares(ArrayUtils.matrix("[[1,2],[2,3],[6,1]]"))); // [2, 5, 5]
        System.out.println(fallingSquares(ArrayUtils.matrix("[[100, 100], [200, 100]]"))); // [100, 100]
        System.out.println(fallingSquares(ArrayUtils.matrix("[[9,1],[6,5],[6,7]]"))); // [1,6,13]
    }

}
