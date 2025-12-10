/**
 * 3577. 统计计算机解锁顺序排列数：https://leetcode.cn/problems/count-the-number-of-computer-unlocking-permutations
 */
public class CountTheNumberOfComputerUnlockingPermutations {

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        int mod = 1000000007;
        long ans = 1;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
            ans = ans * i % mod;
        }
        return (int) ans;
    }

}
