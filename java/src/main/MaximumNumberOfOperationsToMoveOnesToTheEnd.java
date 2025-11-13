/**
 * 3228. 将 1 移动到末尾的最大操作次数：https://leetcode.cn/problems/maximum-number-of-operations-to-move-ones-to-the-end
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {

    public int maxOperations(String s) {
        int ans = 0;
        int onesCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } else {
                if (i == s.length() - 1 || s.charAt(i + 1) == '1') {
                    ans += onesCount;
                }
            }
        }
        return ans;
    }

}
