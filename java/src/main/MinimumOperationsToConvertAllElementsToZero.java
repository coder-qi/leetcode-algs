/**
 * 3542. 将所有元素变为 0 的最少操作次数：https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero
 */
public class MinimumOperationsToConvertAllElementsToZero {

    public int minOperations(int[] nums) {
        int[] stack = new int[nums.length];
        int si = -1;
        int ans = 0;
        for (int num : nums) {
            int prevNum = -1;
            while (si >= 0 && num < stack[si]) {
                if (prevNum != stack[si]) {
                    ans++;
                }
                prevNum = stack[si--];
            }
            stack[++si] = num;
        }
        int prevNum = -1;
        while (si >= 0) {
            int num = stack[si--];
            if (prevNum != num && num != 0) {
                ans++;
            }
            prevNum = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        MinimumOperationsToConvertAllElementsToZero app = new MinimumOperationsToConvertAllElementsToZero();
        System.out.println(app.minOperations(new int[]{4,4,7,4,3}));
    }

}
