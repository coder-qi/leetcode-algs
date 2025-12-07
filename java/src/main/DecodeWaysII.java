/**
 * 639. 解码方法 II：https://leetcode.cn/problems/decode-ways-ii
 */
public class DecodeWaysII {

    public int numDecodings(String s) {
        int mod = 1000000007;
        char[] str = s.toCharArray();
        int n = str.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = str[0] == '*' ? 9 : (str[0] == '0' ? 0 : 1);
        for (int i = 1; i < n; i++) {
            long cnt = 0;
            if (str[i] == '*') {
                cnt = dp[i] * 9L;
            } else if (str[i] != '0') {
                cnt = dp[i];
            }

            if (str[i - 1] == '*') {
                if (str[i] == '*') {
                    cnt += dp[i - 1] * 15L;
                } else {
                    cnt += dp[i - 1];
                    if (str[i] - '0' <= 6) {
                        cnt += dp[i - 1];
                    }
                }
            } else if (str[i - 1] == '1') {
                if (str[i] == '*') {
                    cnt += dp[i - 1] * 9L;
                } else {
                    cnt += dp[i - 1];
                }
            } else if (str[i - 1] == '2') {
                if (str[i] == '*') {
                    cnt += dp[i - 1] * 6L;
                } else if (str[i] - '0' <= 6) {
                    cnt += dp[i - 1];
                }
            }

            dp[i + 1] = (int)(cnt % mod);
        }
        return dp[n];
    }


    public int numDecodings2(String s) {
        int mod = 1000000007;
        char[] str = s.toCharArray();
        int n = str.length;
        int dp0 = 1;
        int dp1 = str[0] == '*' ? 9 : (str[0] == '0' ? 0 : 1);
        for (int i = 1; i < n; i++) {
            long cnt = 0;
            if (str[i] == '*') {
                cnt = dp1 * 9L;
            } else if (str[i] != '0') {
                cnt = dp1;
            }

            if (str[i - 1] == '*') {
                if (str[i] == '*') {
                    cnt += dp0 * 15L;
                } else {
                    cnt += dp0;
                    if (str[i] - '0' <= 6) {
                        cnt += dp0;
                    }
                }
            } else if (str[i - 1] == '1') {
                if (str[i] == '*') {
                    cnt += dp0 * 9L;
                } else {
                    cnt += dp0;
                }
            } else if (str[i - 1] == '2') {
                if (str[i] == '*') {
                    cnt += dp0 * 6L;
                } else if (str[i] - '0' <= 6) {
                    cnt += dp0;
                }
            }

            dp0 = dp1;
            dp1 = (int)(cnt % mod);
        }
        return dp1;
    }


    public int numDecodings3(String s) {
        int mod = 1000000007;
        char[] str = s.toCharArray();
        int n = str.length;
        int dp0 = 1;
        int dp1 = str[0] == '*' ? 9 : (str[0] == '0' ? 0 : 1);
        for (int i = 1; i < n; i++) {
            long cnt = 0;
            if (str[i] == '*') {
                cnt = dp1 * 9L;
            } else if (str[i] != '0') {
                cnt = dp1;
            }

            if (str[i - 1] != '*' && str[i] != '*') {
                int x = (str[i - 1] - '0') * 10 + (str[i] - '0');
                if (x >= 10 && x <= 26) {
                    cnt += dp0;
                }
            } else if (str[i - 1] == '*' && str[i] == '*') {
                cnt += dp0 * 15L;
            } else if (str[i - 1] == '*') {
                cnt += dp0;
                if (str[i] - '0' <= 6) {
                    cnt += dp0;
                }
            } else {
                if (str[i - 1] == '1') {
                    cnt += dp0 * 9L;
                } else if (str[i - 1] == '2') {
                    cnt += dp0 * 6L;
                }
            }

            dp0 = dp1;
            dp1 = (int)(cnt % mod);
        }
        return dp1;
    }


    public static void main(String[] args) {
        DecodeWaysII d = new DecodeWaysII();
        System.out.println(d.numDecodings3("1*"));
        System.out.println(d.numDecodings3("**")); // 96
        System.out.println(d.numDecodings3("104")); // 1
    }

}
