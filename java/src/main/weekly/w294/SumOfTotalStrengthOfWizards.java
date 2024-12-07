package weekly.w294;

import java.util.ArrayDeque;
import java.util.Deque;

import util.ArrayUtils;

import static util.ResourceUtils.loadTestcase;

/**
 * 6077. 巫师的总力量和：https://leetcode.cn/problems/sum-of-total-strength-of-wizards/
 */
public class SumOfTotalStrengthOfWizards {

    static final int MOD = (int) (1e9 + 7);

    public static int totalStrength(int[] strength) {
        int n = strength.length;
        int[] ss = new int[n + 2]; // 前缀和的前缀和
        long s = 0;
        for (int i = 1; i <= n; i++) {
            s += strength[i - 1];
            ss[i + 1] = (int) ((ss[i] + s) % MOD);
        }
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = -1; i <= n; i++) {
            while (!stack.isEmpty() && getValue(strength, stack.peek()) > getValue(strength, i)) {
                int cur = stack.pop();
                int left = stack.peek() + 1, right = i - 1;
                // cur处的和：strength[cur] * (cur - left + 1) * (ss[right] - ss[cur - 1]) - (right - cur + 1) * (ss[cur - 1] - ss[left - 2])
                long total = ((long)(cur - left + 1) * (ss[right + 2] - ss[cur + 1])
                    - (long)(right - cur + 1) * (ss[cur + 1] - ss[left])) % MOD;
                ans = (ans + strength[cur] * total) % MOD;
            }
            stack.push(i);
        }
        return (int) (ans + MOD) % MOD; // 避免计算出负数
    }

    private static int getValue(int[] strength, int index) {
        return index == -1 || index == strength.length ? Integer.MIN_VALUE : strength[index];
    }


    public static void main(String[] args) {
        System.out.println(totalStrength(ArrayUtils.array("[1,3,1,2]"))); // 44
        System.out.println(totalStrength(ArrayUtils.array("[5,4,6]"))); // 213
        System.out.println(totalStrength(ArrayUtils.array(loadTestcase("4077-testcase-1.txt")))); // 744587013
        System.out.println(totalStrength(ArrayUtils.array(loadTestcase("4077-testcase-2.txt")))); // 213
    }

}
