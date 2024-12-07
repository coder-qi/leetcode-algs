import java.util.HashMap;
import java.util.Map;

/**
 * 447. 回旋镖的数量：https://leetcode.cn/problems/number-of-boomerangs/description/
 */
public class NumberOfBoomerangs {

    public static int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        int n = points.length;
        Map<Integer, Integer> countMap = new HashMap<>(n / 8 < 16 ? 16 : n / 8);
        for (int i = 0; i < n; i++) {
            countMap.clear();
            int[] pi = points[i];
            for (int j = 0; j < n; j++) {
                int[] pj = points[j];
                int dis = (pi[0] - pj[0]) * (pi[0] - pj[0]) + (pi[1] - pj[1]) * (pi[1] - pj[1]);
                countMap.compute(dis, (key, value) -> value == null ? 1 : value + 1);
            }
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                ans += entry.getValue() * (entry.getValue() - 1);
            }
        }
        return ans;
    }

    // 暴力解法，时间复杂度O(n^2)
    public static int numberOfBoomerangs2(int[][] points) {
        int ans = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] pi = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] pj = points[j];
                for (int k = j + 1; k < n; k++) {
                    int[] pk = points[k];
                    // i,j
                    long dis1 = (long) (pi[0] - pj[0]) * (pi[0] - pj[0]) + (long) (pi[1] - pj[1]) * (pi[1] - pj[1]);
                    // i,k
                    long dis2 = (long) (pi[0] - pk[0]) * (pi[0] - pk[0]) + (long) (pi[1] - pk[1]) * (pi[1] - pk[1]);
                    // j,k
                    long dis3 = (long) (pj[0] - pk[0]) * (pj[0] - pk[0]) + (long) (pj[1] - pk[1]) * (pj[1] - pk[1]);
                    if (dis1 == dis2) {
                        ans += 2;
                    }
                    if (dis2 == dis3) {
                        ans += 2;
                    }
                    if (dis1 == dis3) {
                        ans += 2;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][] {
                {0,0},{1,0},{-1,0},{0,1},{0,-1}
        })); // 20
    }

}
