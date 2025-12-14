/**
 * 2147. 分隔长廊的方案数：https://leetcode.cn/problems/number-of-ways-to-divide-a-long-corridor
 */
public class NumberOfWaysToDivideALongCorridor {

    private static final int MOD = 1000000007;

    public int numberOfWays(String corridor) {
        char[] s = corridor.toCharArray();
        int n = s.length;
        int totalSeatCnt = 0;
        for (char ch : s) {
            if (ch == 'S') {
                totalSeatCnt++;
            }
        }
        if (totalSeatCnt == 0 || totalSeatCnt % 2 != 0) {
            return 0;
        }
        long ans = 1;
        for (int i = 0, j = 0; i < n;) {
            int cntS = 0;
            while (j < n && cntS < 2) {
                if (s[j] == 'S') {
                    cntS++;
                }
                j++;
            }
            int cntP = 1;
            while (j < n && s[j] == 'P') {
                cntP++;
                j++;
            }
            if (j == n) {
                cntP = 1;
            }
            ans = ans * cntP % MOD;
            i = j;
        }
        return (int)ans;
    }

    public int numberOfWays2(String corridor) {
        char[] s = corridor.toCharArray();
        int n = s.length;
        long ans = 1;
        for (int i = 0, j = 0; i < n;) {
            int cntS = 0;
            while (j < n && cntS < 2) {
                if (s[j] == 'S') {
                    cntS++;
                }
                j++;
            }
            if (cntS < 2) {
                return 0;
            }
            int cntP = 1;
            while (j < n && s[j] == 'P') {
                cntP++;
                j++;
            }
            if (j == n) {
                cntP = 1;
            }
            ans = ans * cntP % MOD;
            i = j;
        }
        return (int)ans;
    }

    public static void main(String[] args) {
        NumberOfWaysToDivideALongCorridor app = new NumberOfWaysToDivideALongCorridor();
        System.out.println(app.numberOfWays("PPSPSP")); // 1
        System.out.println(app.numberOfWays("SSPPSPS")); // 3
        System.out.println(app.numberOfWays("SSSPPPSPPSPSSSSSSPPPSPP")); // 3
    }

}
