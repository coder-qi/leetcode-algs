import java.util.Arrays;

/**
 * 455. 分发饼干：https://leetcode-cn.com/problems/assign-cookies/
 */
public class AssignCookies {

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; j++) {
            if (s[j] >= g[i]) {
                result++;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[] {1,2,3}, new int[] {1,1})); // 1
        System.out.println(findContentChildren(new int[] {1,2}, new int[] {1,2,3})); // 2
        System.out.println(findContentChildren(new int[] {10,9,8,7}, new int[] {5,6,7,8})); // 2
    }

}
