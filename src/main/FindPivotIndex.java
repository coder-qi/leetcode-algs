/**
 * 724. 寻找数组的中心下标：https://leetcode.cn/problems/find-pivot-index
 */
public class FindPivotIndex {

    public static int pivotIndex(int[] nums) {
        int N = nums.length;
        int[] preSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < N; i++) {
            int leftSum = preSum[i];
            int rightSum = preSum[N] - preSum[i + 1];
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
    }

}
