package weekly.w293;

/**
 * 6065. 按位与结果大于零的最长组合：https://leetcode.cn/problems/largest-combination-with-bitwise-and-greater-than-zero/
 */
public class LargestCombinationWithBitwiseAndGreaterThanZero {

    public static int largestCombination(int[] candidates) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            int cnt = 0;
            for (int candidate : candidates) {
                if ((candidate >> i & 1) != 0) {
                    cnt++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestCombination(new int[] {8, 8}));
    }

}
