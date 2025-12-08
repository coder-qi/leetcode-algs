/**
 * 1416. 恢复数组：https://leetcode.cn/problems/restore-the-array
 */
public class RestoreTheArray {

    public int numberOfArrays(String s, int k) {
        int mod = (int) 1e9 + 7;
        char[] str = s.toCharArray();
        int klen = String.valueOf(k).length();
        int n = str.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            long res = 0;
            long num = 0, p = 1;
            for (int j = i; j >= 0 && (i - j) < klen; j--) {
                num = (str[j] - '0') * p + num;
                p *= 10;
                if (str[j] == '0') {
                    continue;
                }
                if (num > k) {
                    break;
                }
                res += dp[j];
            }
            dp[i + 1] = (int) (res % mod);
        }
        return dp[n];
    }

    public int numberOfArrays2(String s, int k) {
        int mod = (int) 1e9 + 7;
        char[] str = s.toCharArray();
        int klen = String.valueOf(k).length();
        int n = str.length;
        int[] dp = new int[klen];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            long res = 0;
            long num = 0, p = 1;
            for (int j = i; j >= 0 && (i - j) < klen; j--) {
                num = (str[j] - '0') * p + num;
                p *= 10;
                if (str[j] == '0') {
                    continue;
                }
                if (num > k) {
                    break;
                }
                res += dp[j % klen];
            }
            dp[(i + 1) % klen] = (int) (res % mod);
        }
        return dp[n % klen];
    }

    public static void main(String[] args) {
        RestoreTheArray app = new RestoreTheArray();
        System.out.println(app.numberOfArrays2("407780786171321121429620765476840275495357129574174233567552131453038760763182952432348422252546559691171161181440370120987634895458140447952079749439961325982629462531738374032416182281868731817661954890417245087359968833257550123324827240537957646002494771036413572415", 823924906)); // 427125123
    }

}
