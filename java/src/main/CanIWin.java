/**
 * 464. 我能赢吗：https://leetcode.cn/problems/can-i-win/
 */
public class CanIWin {

    int[] memo;
    int maxChoosableInteger, desiredTotal;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false; // 选完所有的数字仍然无法达到desiredTotal
        }
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        memo = new int[1 << maxChoosableInteger];

        return dfs(0, 0);
    }

    private boolean dfs(int useNumbers, int currentTotal) {
        if (memo[useNumbers] != 0) {
            return memo[useNumbers] == 1;
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
        memo[useNumbers] = result ? 1 : -1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CanIWin().canIWin(10, 11)); // false
        System.out.println(new CanIWin().canIWin(10, 0)); // true
        System.out.println(new CanIWin().canIWin(10, 1)); // true
    }

}
