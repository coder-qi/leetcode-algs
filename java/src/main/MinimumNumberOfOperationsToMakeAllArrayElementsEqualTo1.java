/**
 * 2654. 使数组所有元素变成 1 的最少操作次数：https://leetcode.cn/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1
 */
public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    public int minOperations(int[] nums) {
        int res = dfs(nums);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int gcd = gcd(nums[i], nums[i + 1]);
            if (gcd == 1) {
                int k = 0;
                for (int num : nums) {
                    if (num == 1) {
                        k++;
                    }
                }
                return nums.length - k;
            }
            if ((gcd & 1) == 1) {
                int tmp = nums[i];
                nums[i] = gcd;
                int res1 = tmp == gcd ? Integer.MAX_VALUE : dfs(nums);
                nums[i] = tmp;

                tmp = nums[i + 1];
                nums[i + 1] = gcd;
                int res2 = tmp == gcd ? Integer.MAX_VALUE : dfs(nums);
                nums[i + 1] = tmp;

                res1 = Math.min(res1, res2);
                if (res1 != Integer.MAX_VALUE) {
                    res = Math.min(res, res1 + 1);
                }
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static void main(String[] args) {
        MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 app = new MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1();

    }

}
