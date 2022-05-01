package biweekly.w77;

public class MinimumAverageDifference {

    public static int minimumAverageDifference(int[] nums) {
        long[] sum = new long[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] += nums[i] + sum[i - 1];
        }

        int ans = 0;
        long minAvgDiff = Integer.MAX_VALUE;
        for (int i = 0; i < sum.length; i++) {
            long avg = sum[i] / (i + 1);
            if (i < sum.length - 1) {
                avg = Math.abs(avg - (sum[sum.length - 1] - sum[i]) / (sum.length - i - 1));
            }
            if (avg < minAvgDiff) {
                minAvgDiff = avg;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimumAverageDifference(new int[] {2,5,3,9,5,3}));
        System.out.println(minimumAverageDifference(new int[] {2,5,3,9,5,3}));
    }

}
