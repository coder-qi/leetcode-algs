import java.util.Arrays;
import java.util.Comparator;

/**
 * 768. 最多能完成排序的块 II：https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 */
public class MaxChunksToMakeSortedII {

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[] {5,4,3,2,1})); // 1
        System.out.println(maxChunksToSorted(new int[] {2,1,3,4,4})); // 4
    }

    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[][] m = new int[n][2];
        for (int i = 0; i < n; i++) {
            m[i][0] = arr[i];
            m[i][1] = i;
        }
        Arrays.sort(m, Comparator.comparingInt(a -> a[0]));
        int ans = 0, max = -1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, m[i][1]);
            if (max == i) {
                ans++;
            }
        }
        return ans;
    }

}
