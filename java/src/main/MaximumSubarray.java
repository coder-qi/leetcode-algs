/**
 * 最大子数组和：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    /**
     * 时间复杂度为O(N)的解法
     */
    public static int maxSubArray2(int[] nums) {
        int sum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private static Status getInfo(int[] nums, int left, int right) {
       if (left == right) {
           return new Status(nums[left], nums[left], nums[left], nums[left]);
       }
       int mid = (left + right) >> 1;
       Status lSub = getInfo(nums, left, mid);
       Status rSub = getInfo(nums, mid + 1, right);
       return pushUp(lSub, rSub);
    }

    private static Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }

    private static class Status {
        private int lSum, rSum, mSum, iSum;
        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[] {1}));
        System.out.println(maxSubArray(new int[] {5,4,-1,7,8}));
        System.out.println(maxSubArray(new int[] {1,2,-1,-2,2,1,-2,1,4,-5,4}));
    }

}
