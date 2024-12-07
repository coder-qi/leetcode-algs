import java.util.stream.IntStream;

import static util.ArrayUtils.array;

/**
 * 1051. 高度检查器：https://leetcode.cn/problems/height-checker/
 */
public class HeightChecker {

    public static int heightChecker(int[] heights) {
        int max = IntStream.of(heights).max().getAsInt();
        int[] count = new int[max + 1];
        for (int h : heights) {
            count[h]++;
        }
        int ans = 0;
        for (int i = 0, pos = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                if (heights[pos++] != i) {
                    ans++;
                }
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
