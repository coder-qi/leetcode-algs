import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3186. 施咒的最大总伤害：https://leetcode.cn/problems/maximum-total-damage-with-spell-casting
 */
public class MaximumTotalDamageWithSpellCasting {

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(power, n - 1, memo);
    }

    private long dfs(int[] power, int i, long[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        int j = i;
        while (j - 1 >= 0 && power[j - 1] == power[i]) {
            j--;
        }
        int k = j - 1;
        while (k >= 0 && (power[i] - power[k]) <= 2) {
            k--;
        }
        return memo[i] = Long.max(dfs(power, j - 1, memo), (long) (i - j + 1) * power[i] + dfs(power, k, memo));
    }

    public long maximumTotalDamage2(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        long[] f = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j < n && power[j] == power[i - 1]) {
                j++;
            }
            int k = i - 1;
            while (k - 1 >= 0 && (power[i - 1] - power[k - 1]) <= 2) {
                k--;
            }
            f[j] = Long.max(f[i - 1], (long) (j - i + 1) * power[i - 1] + f[k]);
            i = j;
        }
        return f[n];
    }

    public long maximumTotalDamage3(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        long[] f = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j < n && power[j] == power[i - 1]) {
                j++;
            }
            f[j] = f[i - 1];
            int k = upperBound(power, 0, i, power[i - 1] - 2);
            f[j] = Long.max(f[i - 1], (long) (j - i + 1) * power[i - 1] + f[k]);
            i = j;
        }
        return f[n];
    }

    private int upperBound(int[] power, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (power[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static class Solution {
        public long maximumTotalDamage(int[] power) {
            Map<Integer, Integer> cnt = new HashMap<>(power.length, 1);
            for (int x : power) {
                cnt.merge(x, 1, Integer::sum);
            }
            int n = cnt.size();
            int[] a = new int[n];
            int i = 0;
            for (int x : cnt.keySet()) {
                a[i++] = x;
            }
            Arrays.sort(a);
            long[] memo = new long[n];
            Arrays.fill(memo, -1);
            return dfs(a, n - 1, cnt, memo);
        }

        private long dfs(int[] a, int i, Map<Integer, Integer> cnt, long[] memo) {
            if (i < 0) {
                return 0;
            }
            if (memo[i] != -1) {
                return memo[i];
            }
            int j = i - 1;
            while (j >= 0 && a[i] - a[j] <= 2) {
                j--;
            }
            return memo[i] = Long.max(dfs(a, i - 1, cnt, memo), dfs(a, j, cnt, memo) + (long) a[i] * cnt.get(a[i]));
        }

        public long maximumTotalDamage2(int[] power) {
            Map<Integer, Integer> cnt = new HashMap<>(power.length, 1);
            for (int x : power) {
                cnt.merge(x, 1, Integer::sum);
            }
            int n = cnt.size();
            int[] a = new int[n];
            int k = 0;
            for (int x : cnt.keySet()) {
                a[k++] = x;
            }
            Arrays.sort(a);

            long[] f = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                int j = i - 1;
                int x = a[i - 1];
                while (j - 1 >= 0 && x - a[j - 1] <= 2) {
                    j--;
                }
                f[i] = Long.max(f[i - 1], f[j] + (long) x * cnt.get(x));
            }
            return f[n];
        }

    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting app = new MaximumTotalDamageWithSpellCasting();
        System.out.println(app.maximumTotalDamage3(new int[]{1,1,3,4})); // 6
        System.out.println(app.maximumTotalDamage3(new int[]{7,1,6,3})); // 10
        System.out.println(app.maximumTotalDamage3(new int[]{5,9,2,10,2,7,10,9,3,8})); // 31
    }

}
