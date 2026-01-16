import java.util.HashSet;
import java.util.Set;

/**
 * 2975. 移除栅栏得到的正方形田地的最大面积：https://leetcode.cn/problems/maximum-square-area-by-removing-fences-from-a-field
 */
public class MaximumSquareAreaByRemovingFencesFromAField {

    int mod = (int) (1e9 + 7);

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        if (m == n) {
            return (int) (((long) (m - 1) * (n - 1)) % mod);
        }
        Set<Integer> hWidths = new HashSet<>(hFences.length);
        hWidths.add(m - 1);
        for (int i = 0; i < hFences.length; i++) {
            hWidths.add(hFences[i] - 1);
            hWidths.add(m - hFences[i]);
            for (int j = i + 1; j < hFences.length; j++) {
                hWidths.add(Math.abs(hFences[i] - hFences[j]));
            }
        }

        long ans = hWidths.contains(n - 1) ? (long) (n - 1) * (n - 1) : -1;
        for (int i = 0; i < vFences.length; i++) {
            if (hWidths.contains(vFences[i] - 1)) {
                ans = Math.max(ans, (long) (vFences[i] - 1) * (vFences[i] - 1));
            }
            if (hWidths.contains(n - vFences[i])) {
                ans = Math.max(ans, (long) (n - vFences[i]) * (n - vFences[i]));
            }
            for (int j = i + 1; j < vFences.length; j++) {
                int v = Math.abs(vFences[i] - vFences[j]);
                if (hWidths.contains(v)) {
                    ans = Math.max(ans, (long) v * v);
                }
            }
        }
        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        MaximumSquareAreaByRemovingFencesFromAField app = new MaximumSquareAreaByRemovingFencesFromAField();
        System.out.println(app.maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
    }

}
