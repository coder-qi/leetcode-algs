package weekly.w291;

import java.util.Arrays;

/**
 * 6050. 字符串的总引力：https://leetcode-cn.com/problems/total-appeal-of-a-string/
 */
public class TotalAppealOfAString {

    public static long appealSum(String s) {
        long ans = 0;
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0, sum = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            sum += i - pos[j];
            ans += sum;
            pos[j] = i;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(appealSum("abbca")); // 28
        System.out.println(appealSum("code")); // 20
    }

}
