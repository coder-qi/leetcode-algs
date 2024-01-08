/**
 * 447. 回旋镖的数量：https://leetcode.cn/problems/number-of-boomerangs/description/
 */
public class NumberOfBoomerangs {

    // 暴力解法，时间复杂度O(n^2)
    public static int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            int[] pi = points[i];
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                int[] pj = points[j];
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int[] pk = points[k];
                    long dis1 = (long) (pi[0] - pj[0]) * (pi[0] - pj[0]) + (long) (pi[1] - pj[1]) * (pi[1] - pj[1]);
                    long dis2 = (long) (pi[0] - pk[0]) * (pi[0] - pk[0]) + (long) (pi[1] - pk[1]) * (pi[1] - pk[1]);
                    if (dis1 == dis2) {
                        ans++;
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
