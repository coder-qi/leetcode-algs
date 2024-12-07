package weekly.w300;

/**
 * 2327. 知道秘密的人数：https://leetcode.cn/problems/number-of-people-aware-of-a-secret/
 */
public class NumberOfPeopleAwareOfASecret {

    static final int MOD = (int) (1e9 + 7);

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] sum = new int[n + 1];
        sum[1] = 1;
        for (int i = 2; i <= n; i++) {
            int right = Math.max(0, i - delay);
            int left = Math.max(0, i - forget);
            int f = (sum[right] - sum[left]) % MOD;
            sum[i] = (sum[i - 1] + f) % MOD;
        }
        return ((sum[n] - sum[Math.max(0, n - forget)]) % MOD + MOD) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4)); // 5
        System.out.println(peopleAwareOfSecret(4, 1, 3)); // 6
        System.out.println(peopleAwareOfSecret(1000, 1, 2)); // 2
        System.out.println(peopleAwareOfSecret(684, 18, 496)); // 653668527
        System.out.println(peopleAwareOfSecret(289, 7, 23)); // 790409951
    }

}
