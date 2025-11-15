import java.util.ArrayList;
import java.util.List;

/**
 * 3234. 统计 1 显著的字符串的数量：https://leetcode.cn/problems/count-the-number-of-substrings-with-dominant-ones
 */
public class CountTheNumberOfSubstringsWithDominantOnes {

    public int numberOfSubstrings(String s) {
        int ans = 0;
        char[] chars = s.toCharArray();
        List<Integer> pos0 = new ArrayList<>();
        pos0.add(-1);
        int total1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                pos0.add(i);
            } else {
                total1++;
                ans += i - pos0.getLast();
            }

            for (int j = pos0.size() - 1; j >= 1; j--) {
                int cnt0 = pos0.size() - j;
                if (cnt0 * cnt0 > total1) {
                    break;
                }
                int p = pos0.get(j - 1);
                int q = pos0.get(j);
                int cnt1 = i - q + 1 - cnt0;
                ans += Math.max(q - Math.max(cnt0 * cnt0 - cnt1, 0) - p, 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountTheNumberOfSubstringsWithDominantOnes app = new CountTheNumberOfSubstringsWithDominantOnes();
        System.out.println(app.numberOfSubstrings("00011")); // 5
        System.out.println(app.numberOfSubstrings("10110")); // 11
        System.out.println(app.numberOfSubstrings("101101")); // 16
    }

}
