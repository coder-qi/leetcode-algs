/**
 * 3190. 使所有元素都可以被 3 整除的最少操作数：https://leetcode.cn/problems/find-minimum-operations-to-make-all-elements-divisible-by-three
 */
public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {

    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }

}
