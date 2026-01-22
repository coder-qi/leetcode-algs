/**
 * 3507. 移除最小数对使数组有序 I：https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-i
 */
public class MinimumPairRemovalToSortArrayI {

    public int minimumPairRemoval(int[] nums) {
        int len = nums.length;
        while (!check(nums, len)) {
            int minSum = Integer.MAX_VALUE;
            int i = 0;
            for (int j = 0; j < len - 1; j++) {
                int s = nums[j] + nums[j + 1];
                if (s < minSum) {
                    i = j;
                    minSum = s;
                }
            }
            nums[i] = minSum;
            System.arraycopy(nums, i + 2, nums, i + 1, len - (i + 2));
            len--;
        }
        return nums.length - len;
    }

    private boolean check(int[] nums, int len) {
        for (int i = 1; i < len; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumPairRemovalToSortArrayI app = new MinimumPairRemovalToSortArrayI();
        System.out.println(app.minimumPairRemoval(new int[]{5,2,3,1}));
        System.out.println(app.minimumPairRemoval(new int[]{1,2,2}));
    }

}
