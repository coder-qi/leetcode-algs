
package weekly.w297;

import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 5289. 公平分发饼干：https://leetcode.cn/problems/fair-distribution-of-cookies/
 */
public class FairDistributionOfCookies {

    public int distributeCookies(int[] cookies, int k) {
        Arrays.sort(cookies);
        int left = cookies[cookies.length - 1], right = Arrays.stream(cookies).sum();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (check(cookies, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[] cookies, int k, int limit) {
        return dfs(cookies, new int[k], cookies.length - 1, limit);
    }

    private boolean dfs(int[] cookies, int[] count, int index, int limit) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < count.length; i++) {
            count[i] += cookies[index];
            if (count[i] <= limit && dfs(cookies, count, index - 1, limit)) {
                return true;
            }
            count[i] -= cookies[index];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new FairDistributionOfCookies()
            .distributeCookies(array("[8,15,10,20,8]"), 2)); // 31
        System.out.println(new FairDistributionOfCookies()
            .distributeCookies(array("[6,1,3,2,2,4,1,2]"), 3)); // 7
    }

}
