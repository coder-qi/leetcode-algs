import java.util.Random;

import util.ArrayUtils;

/**
 * 497. 非重叠矩形中的随机点：https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 */
public class RandomPointInNonOverlappingRectangles {

    public static void main(String[] args) {
        Solution solution = new Solution(ArrayUtils.matrix("[[-2, -2, 1, 1], [2, 2, 4, 6]]"));
        solution.pick(); // 返回 [1, -2]
        solution.pick(); // 返回 [1, -1]
        solution.pick(); // 返回 [-1, -2]
        solution.pick(); // 返回 [-2, -2]
        solution.pick(); // 返回 [0, 0]
    }

    static class Solution {

        final int[][] rects;
        final Random random = new Random();
        final int[] area;

        public Solution(int[][] rects) {
            this.rects = rects;
            area = new int[rects.length + 1];
            for (int i = 0; i < rects.length; i++) {
                int a = rects[i][0], b = rects[i][1], x = rects[i][2], y = rects[i][3];
                area[i + 1] = area[i] + (x - a + 1) * (y - b + 1);
            }
        }

        public int[] pick() {
            int k = random.nextInt(area[area.length - 1]);
            int rectIndex = binarySearch(area, k + 1) - 1;
            k -= area[rectIndex];
            int[] rect = rects[rectIndex];
            int a = rect[0], b = rect[1], y = rect[3];
            int col = y - b + 1;
            int da = k / col;
            int db = k - col * da;
            return new int[] {a + da, b + db};
        }

        private int binarySearch(int[] area, int target) {
            int left = 0, right = area.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (area[mid] > target) {
                    right = mid - 1;
                } else if (area[mid] < target) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return left;
        }
    }

}
