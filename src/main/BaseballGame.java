import java.util.ArrayList;
import java.util.List;

/**
 * 682. 棒球比赛：https://leetcode.cn/problems/baseball-game
 */
public class BaseballGame {

    public static int calPoints(String[] operations) {
        List<Integer> scores = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if ("+".equals(op)) {
                int v = scores.get(scores.size() - 1) + scores.get(scores.size() - 2);
                scores.add(v);
                ans += v;
            } else if ("D".equals(op)) {
                int v = scores.get(scores.size() - 1) * 2;
                scores.add(v);
                ans += v;
            } else if ("C".equals(op)) {
                ans -= scores.remove(scores.size() - 1);
            } else {
                int v = Integer.parseInt(op);
                scores.add(v);
                ans += v;
            }
        }
        return ans;
    }

}
