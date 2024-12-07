/**
 * 1186. 删除一次得到子数组最大和：https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion
 */
public class MaximumSubarraySumWithOneDeletion {

    public static int maximumSum(int[] arr) {
        int dp0 = arr[0];
        int dp1 = 0;
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp1 = Math.max(dp0, dp1 + arr[i]);
            dp0 = Math.max(dp0, 0) + arr[i];
            ans = Math.max(ans, Math.max(dp0, dp1));
        }
        return ans;
    }

    public static void main(String[] args) {
        //System.out.println(maximumSum(new int[] {1,-4,-5,-2,5,0,-1,2}));
        System.out.println(maximumSum(new int[] {11,-10,-11,8,7,-6,9,4,11,6,5,0}));
    }

}
