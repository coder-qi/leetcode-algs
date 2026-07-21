import java.util.ArrayList;
import java.util.List;

/**
 * 3499. 操作后最大活跃区段数 I：https://leetcode.cn/problems/maximize-active-section-with-trade-i
 */
public class MaximizeActiveSectionWithTradeI {

    public int maxActiveSectionsAfterTrade(String s) {
        s = "1" + s + "1";

        List<Integer> len = new ArrayList<>();
        List<Character> ch = new ArrayList<>();

        int i = 0;
        int ones = 0;

        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }

            ch.add(s.charAt(i));
            len.add(j - i);

            if (s.charAt(i) == '1') {
                ones += j - i;
            }

            i = j;
        }

        int ans = ones;

        for (int k = 2; k + 2 < len.size(); k += 2) {
            ans = Math.max(ans,
                    ones + len.get(k - 1) + len.get(k + 1));
        }

        return ans - 2; // 去掉前后补的两个1
    }

    public static void main(String[] args) {
        MaximizeActiveSectionWithTradeI app = new MaximizeActiveSectionWithTradeI();
        System.out.println(app.maxActiveSectionsAfterTrade("01010"));
    }

}
