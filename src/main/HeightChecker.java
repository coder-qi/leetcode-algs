import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 1051. 高度检查器：https://leetcode.cn/problems/height-checker/
 */
public class HeightChecker {

    public static int heightChecker(int[] heights) {
        int[] expected = new int[heights.length];
        System.arraycopy(heights, 0, expected, 0, heights.length);
        Arrays.sort(expected);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(heightChecker(array("[1,1,4,2,1,3]"))); // 3
        System.out.println(heightChecker(array("[5,1,2,3,4]"))); // 5
        System.out.println(heightChecker(array("[1,2,3,4,5]"))); // 0
    }

}
