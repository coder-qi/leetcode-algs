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
            map.put(heights[i], map.getOrDefault(heights[i], 0));
            for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext();) {
                Map.Entry<Integer, Integer> entry = it.next();
                //if (entry.getKey() != heights[i]) {
                    if ((heights[i - 1] <= heights[i] && entry.getKey() <= heights[i]) || entry.getValue() == 0) {
                        map.put(entry.getKey(), entry.getValue() + 1);
                    } else {
                        it.remove();
                    }
                //}
                if (entry.getKey() * entry.getValue() > ans) {
                    ans = entry.getKey() * entry.getValue();
                }
            }
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
    }

}
