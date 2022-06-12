
package weekly.w297;

import java.util.Arrays;

import util.ArrayUtils;

import static util.ArrayUtils.array;

/**
 * 5289. 公平分发饼干：https://leetcode.cn/problems/fair-distribution-of-cookies/
 */
public class FairDistributionOfCookies {

    int[] count;
    int k;
    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        count = new int[k];
        this.k = k;
        dfs(cookies, 0);
        return ans;
    }

    private void dfs(int[] cookies, int index) {
        if (index == cookies.length) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                max = Math.max(max, count[i]);
            }
            ans = Math.min(ans, max);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (count[i] + cookies[index] <= ans) { // 剪枝
                count[i] += cookies[index];
                dfs(cookies, index + 1);
                count[i] -= cookies[index];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new FairDistributionOfCookies()
            .distributeCookies(array("[8,15,10,20,8]"), 2)); // 31
        System.out.println(new FairDistributionOfCookies()
            .distributeCookies(array("[6,1,3,2,2,4,1,2]"), 3)); // 7
    }

}
