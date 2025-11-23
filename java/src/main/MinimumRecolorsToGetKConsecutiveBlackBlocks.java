/**
 * 2379. 得到 K 个黑块的最少涂色次数：https://leetcode.cn/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 */
public class MinimumRecolorsToGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        int ans = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                count++;
            }
            if (i + 1 < k) {
                continue;
            }
            ans = Math.min(ans, count);
            if (blocks.charAt(i - k + 1) == 'W') {
                count--;
            }
        }
        return ans;
    }

}
