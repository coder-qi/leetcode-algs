import java.util.Arrays;

/**
 * 740. 删除并获得点数：https://leetcode.cn/problems/delete-and-earn
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return dfs(nums, n - 1, memo);
    }

    private int dfs(int[] nums, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int j = i;
        int res1 = dfs(nums, j - 1, memo);
        int res2 = nums[i];
        while (j > 0 && nums[j - 1] == nums[i]) {
            res2 += nums[i];
            j--;
        }
        while (j > 0 && nums[j - 1] + 1 == nums[i]) {
            j--;
        }
        res2 += dfs(nums, j - 1, memo);
        return memo[i] = Math.max(res1, res2);
    }

    public int deleteAndEarn2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = i;
            int res1 = f[j - 1];
            int res2 = nums[i - 1];
            while (j > 1 && nums[j - 2] == nums[i - 1]) {
                res2 += nums[i - 1];
                j--;
            }
            while (j > 1 && nums[j - 2] + 1 == nums[i - 1]) {
                j--;
            }
            res2 += f[j - 1];
            f[i] = Math.max(res1, res2);
        }
        return f[n];
    }

    public int deleteAndEarn3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] f = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            int s = nums[i - 1];
            int j = i;
            while (j < n && nums[j] == nums[i - 1]) {
                s += nums[j];
                j++;
            }
            int prev = i == 1 ? Integer.MIN_VALUE : nums[i - 2];
            f[j][0] = Integer.max(f[i - 1][0], f[i - 1][1]);
            f[j][1] = s + Integer.max(f[i - 1][0], prev == nums[i - 1] - 1 ? 0 : f[i - 1][1]);
            i = j;
        }
        return Integer.max(f[n][0], f[n][1]);
    }

    public int deleteAndEarn4(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int f0 = 0, f1 = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j < n && nums[j] == nums[i - 1]) {
                j++;
            }
            int prev = i == 1 ? Integer.MIN_VALUE : nums[i - 2];
            int newF0 = Integer.max(f0, f1);
            int newF1 = (j - i + 1) * nums[i - 1] + Integer.max(f0, prev == nums[i - 1] - 1 ? 0 : f1);
            f0 = newF0;
            f1 = newF1;
            i = j;
        }
        return Integer.max(f0, f1);
    }


    public int deleteAndEarn5(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] arr = new int[max + 1];
        for (int num : nums) {
            arr[num] += num;
        }
        return rob(arr);
    }

    private int rob(int[] nums) {
        int f0 = 0, f1 = 0;
        for (int num : nums) {
            int newF = Math.max(num + f0, f1);
            f0 = f1;
            f1 = newF;
        }
        return f1;
    }

    public static void main(String[] args) {
        DeleteAndEarn app = new DeleteAndEarn();
        System.out.println(app.deleteAndEarn(new int[]{3,4,2}));
        System.out.println(app.deleteAndEarn3(new int[]{2,2,3,3,3,4}));
    }

}
