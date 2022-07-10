package weekly.w300;

/**
 * 2327. 知道秘密的人数：https://leetcode.cn/problems/number-of-people-aware-of-a-secret/
 */
public class NumberOfPeopleAwareOfASecret {

    static final int MOD = (int) (1e9 + 7);

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        int[] arr = new int[forget];
        arr[0] = 1;
        for (int i = 2; i <= n; i++) {
            int cnt = 0;
            for (int j = forget - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
                if (j >= delay - 1) {
                    cnt = (cnt + arr[j]) % MOD;
                }
            }
            arr[0] = cnt;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = (ans + arr[i]) % MOD;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4)); // 5
        System.out.println(peopleAwareOfSecret(4, 1, 3)); // 6
    }

}
