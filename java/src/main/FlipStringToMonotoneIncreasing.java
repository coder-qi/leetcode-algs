/**
 * 926. 将字符串翻转到单调递增：https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 */
public class FlipStringToMonotoneIncreasing {

    public static int minFlipsMonoIncr(String s) {
        int n = s.length();
        int dp0 = 0, dp1 = 0;
        for (int i = 0; i < n; i++) {
            dp1 = Math.min(dp0, dp1);
            if (s.charAt(i) == '0') {
                dp1++;
            } else {
                dp0++;
            }
        }
        return Math.min(dp0, dp1);
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("00110")); // 1
        System.out.println(minFlipsMonoIncr("010110")); // 2
        System.out.println(minFlipsMonoIncr("00011000")); // 2
    }

}
