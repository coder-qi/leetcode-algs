import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 768. 最多能完成排序的块 II：https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 */
public class MaxChunksToMakeSortedII {

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[] {5,4,3,2,1})); // 1
        System.out.println(maxChunksToSorted(new int[] {2,1,3,4,4})); // 4
    }

    public static int maxChunksToSorted(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i], y = sortedArr[i];
            count.put(x, count.getOrDefault(x, 0) + 1);
            if (count.get(x) == 0) {
                count.remove(x);
            }
            count.put(y, count.getOrDefault(y, 0) - 1);
            if (count.get(y) == 0) {
                count.remove(y);
            }
            if (count.isEmpty()) {
                ans++;
            }
        }
        return ans;
    }

}
