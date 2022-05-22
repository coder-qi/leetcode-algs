import java.util.HashMap;
import java.util.Map;

/**
 * 464. 我能赢吗：https://leetcode.cn/problems/can-i-win/
 */
public class CanIWin {

    Map<Integer, Boolean> memo = new HashMap<>();
    int maxChoosableInteger, desiredTotal;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false; // 选完所有的数字仍然无法达到desiredTotal
        }
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        return dfs(0, 0);
    }

    private boolean dfs(int useNumbers, int currentTotal) {
        if (memo.containsKey(useNumbers)) {
            return memo.get(useNumbers);
        }
        boolean result = false;
        for (int i = 0; i < maxChoosableInteger; i++) {
            if (((useNumbers >> i) & 1) == 0) {
                if (i + 1 + currentTotal >= desiredTotal) {
                    result = true;
                    break;
                }
                if (!dfs(useNumbers | (1 << i), i + 1 + currentTotal)) {
                    result = true; // 下一个玩家没有赢，则表示当前玩家赢了
                    break;
                }
            }
        }
        memo.put(useNumbers, result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CanIWin().canIWin(10, 11));
        System.out.println(new CanIWin().canIWin(10, 0));
        System.out.println(new CanIWin().canIWin(10, 1));
    }

}
