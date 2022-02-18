import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 柱状图中最大的矩形：https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = heights[0];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(heights[0], 1);
        for (int i = 1; i < n; i++) {
            int cnt = map.getOrDefault(heights[i], 0) + 1;
            boolean curUp = heights[i - 1] <= heights[i];
            for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
                Map.Entry<Integer, Integer> entry = it.next();
                if (curUp) {
                    if (entry.getKey() <= heights[i]) {
                        map.put(entry.getKey(), entry.getValue() + 1);
                    }
                } else {
                    if (entry.getKey() > heights[i]) {
                        cnt++;
                    }
                    it.remove();
                }
                if (entry.getKey() * entry.getValue() > ans) {
                    ans = entry.getKey() * entry.getValue();
                }
            }
            if (heights[i] * cnt > ans) {
                ans = heights[i] * cnt;
            }
            map.put(heights[i], cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[] {2,1,5,6,2,3}));
        System.out.println(largestRectangleArea(new int[] {2,4}));
        System.out.println(largestRectangleArea(new int[] {1,2,2}));
        System.out.println(largestRectangleArea(new int[] {1,2,3,4,5}));
        System.out.println(largestRectangleArea(new int[] {0, 9}));
        System.out.println(largestRectangleArea(new int[] {1, 1}));
        System.out.println(largestRectangleArea(new int[] {2, 1, 2}));
        System.out.println(largestRectangleArea(new int[] {4,2,0,3,2,5}));
        System.out.println(largestRectangleArea(new int[] {2,1,4,5,1,3,3}));
    }

}
