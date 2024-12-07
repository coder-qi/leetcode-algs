package biweekly.w81;

/**
 * 2317. 操作后的最大异或和：https://leetcode.cn/problems/maximum-xor-after-operations/
 */
public class MaximumXorAfterOperations {

    public static int maximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans |= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumXOR(new int[] {3,2,4,6})); // 7
        System.out.println(maximumXOR(new int[] {1,2,3,9,2})); // 11
    }

}
