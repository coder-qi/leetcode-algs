/**
 * 769. 最多能完成排序的块：https://leetcode.cn/problems/max-chunks-to-make-sorted/
 */
public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        System.out.println(maxChunksToSorted(new int[] {4,3,2,1,0})); // 1
        System.out.println(maxChunksToSorted(new int[] {1,0,2,3,4})); // 4
        System.out.println(maxChunksToSorted(new int[] {0,1,2,3,4})); // 5
    }

    public static int maxChunksToSorted(int[] arr) {
        int ans = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) {
                ans++;
            }
        }
        return ans;
    }

}
