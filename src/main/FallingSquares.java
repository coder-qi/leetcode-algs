import java.util.ArrayList;
import java.util.Iterator;
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
            Integer lp = heightMap.higherKey(left), rp = heightMap.higherKey(right);

            // 计算第i个掉落的方块的最大高度
            int height = 0;
            Integer prevLeftKey = lp != null ? heightMap.lowerKey(lp) : heightMap.lastKey();
            Map<Integer, Integer> tail = prevLeftKey != null ? heightMap.tailMap(prevLeftKey) : heightMap;
            for (Map.Entry<Integer, Integer> entry : tail.entrySet()) {
                if (entry.getKey().equals(rp)) {
                    break;
                }
                height = Math.max(height, entry.getValue() + sideLength);
            }

            Integer prevRightKey = rp != null ? heightMap.lowerKey(rp) : heightMap.lastKey();
            int rHeight = prevRightKey != null ? heightMap.get(prevRightKey) : 0;
            // 清除 heightMap 中位于(left, right] 内的点
            for (Iterator<Integer> it = tail.keySet().iterator(); it.hasNext();) {
                Integer tmp = it.next();
                if (lp == null || tmp < lp) {
                    continue;
                }
                if (rp != null && tmp >= rp) {
                    break;
                }
                it.remove();
            }
            heightMap.put(left, height);
            if (rp == null || rp != right + 1) {
                heightMap.put(right + 1, rHeight);
            }
            heights.add(i > 0 ? Math.max(heights.get(i - 1), height) : height);
        }
        return heights;
    }

    public static void main(String[] args) {
        System.out.println(fallingSquares(ArrayUtils.matrix("[[1,2],[2,3],[6,1]]"))); // [2, 5, 5]
        System.out.println(fallingSquares(ArrayUtils.matrix("[[100, 100], [200, 100]]"))); // [100, 100]
    }

}
