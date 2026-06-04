/**
 * 3751. 范围内总波动值 I：https://leetcode.cn/problems/total-waviness-of-numbers-in-range-i/
 */
public class TotalWavinessOfNumbersInRangeI {

    public int totalWaviness(int num1, int num2) {
        num1 = Math.max(num1, 100);
        int ans = 0;
        for (int i = num1; i <= num2; i++) {
            char[] str = String.valueOf(i).toCharArray();
            for (int j = 1; j < str.length - 1; j++) {
                if (str[j] > str[j - 1] && str[j] > str[j + 1]) {
                    ans++;
                } else if (str[j] < str[j - 1] && str[j] < str[j + 1]) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
