package weekly.w299;

/**
 * 2320. 统计放置房子的方式数：https://leetcode.cn/problems/count-number-of-ways-to-place-houses/
 */
public class CountNumberOfWaysToPlaceHouses {

    static final int MOD = (int) (1e9 + 7);

    public static int countHousePlacements(int n) {
        int prev = 1, next = 1;
        for (int i = 0; i < n; i++) {
            int oldNext = next;
            next = (prev + next) % MOD;
            prev = oldNext;
        }
        return (int) ((next * (long)next) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(countHousePlacements(1)); // 4
        System.out.println(countHousePlacements(2)); // 9
    }

}
