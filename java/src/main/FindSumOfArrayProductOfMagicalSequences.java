import java.util.HashMap;
import java.util.Map;

/**
 * 3539. 魔法序列的数组乘积之和：https://leetcode.cn/problems/find-sum-of-array-product-of-magical-sequences
 */
public class FindSumOfArrayProductOfMagicalSequences {

    static final int MOD = 1_000_000_007;


    public int magicalSum(int m, int k, int[] nums) {
        Map<Long, Integer>[] memo = new Map[m + 1];
        for(int i = 0; i <= m; i++) {
            memo[i] = new HashMap<>();
        }
        return process(m, 0, nums, k, memo);
    }

    private int process(int len, long sum, int[] nums, int k, Map<Long, Integer>[] memo) {
        if (len == 0) {
            return Long.bitCount(sum) == k ? 1 : 0;
        }
        Map<Long, Integer> map = memo[len];
        if (map.containsKey(sum)) {
            return map.get(sum);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (int) (((long)nums[i] * process(len - 1, sum + (1L << i), nums, k, memo)) % MOD);
            result %= MOD;
        }
        memo[len].put(sum, result);
        return result;
    }

    public static void main(String[] args) {
        FindSumOfArrayProductOfMagicalSequences sol = new FindSumOfArrayProductOfMagicalSequences();
        System.out.println(sol.magicalSum(5, 5, new int[]{1, 10, 100, 10000, 1000000})); // 991600007
        System.out.println(sol.magicalSum(2, 2, new int[]{5,4,3,2,1})); // 170
        System.out.println(sol.magicalSum(2, 1, new int[]{63})); // 3969
        System.out.println(sol.magicalSum(3, 2, new int[]{33})); // 35937
        System.out.println(sol.magicalSum(9, 4, new int[]{43,3,46,22,44,21,14})); // 424485515
        System.out.println(sol.magicalSum(8, 8, new int[]{4475,37658,51018,12424,65157,27914,31161,25310,97672,53516,26018,1860,47220,27702,77234,6951,22039,9184,64449,45837,58613,53764,24216,73423,68676,15003}));
    }

}
