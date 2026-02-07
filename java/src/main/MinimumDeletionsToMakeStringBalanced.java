/**
 * 1653. 使字符串平衡的最少删除次数：https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced
 */
public class MinimumDeletionsToMakeStringBalanced {

    public int minimumDeletions(String s) {
        int f = 0;
        int bCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'b') {
                bCount++;
            } else {
                f = Math.min(f + 1, bCount);
            }
        }
        return f;
    }

}
