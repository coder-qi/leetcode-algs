/**
 * 1732. 找到最高海拔：https://leetcode.cn/problems/find-the-highest-altitude
 */
public class FindTheHighestAltitude {

    public int largestAltitude(int[] gain) {
        int ans = 0;
        int height = 0;
        for (int g : gain) {
            height += g;
            ans = Math.max(ans, height);
        }
        return ans;
    }

}
