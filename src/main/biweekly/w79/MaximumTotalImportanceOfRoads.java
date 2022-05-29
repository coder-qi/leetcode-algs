
package biweekly.w79;

import java.util.Arrays;

import static util.ArrayUtils.matrix;
import static util.ResourceUtils.loadTestcase;

/**
 * 6085. 道路的最大总重要性：https://leetcode.cn/problems/maximum-total-importance-of-roads/
 */
public class MaximumTotalImportanceOfRoads {

    public static long maximumImportance(int n, int[][] roads) {
        long[] indegree = new long[n];
        for (int i = 0; i < roads.length; i++) {
            indegree[roads[i][0]]++;
            indegree[roads[i][1]]++;
        }
        long ans = 0;
        Arrays.sort(indegree);
        for (int i = 0; i < n; i++) {
            ans += (i + 1) * indegree[i];
            System.out.println(ans);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(maximumImportance(5,
            matrix("[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]"))); // 43
        System.out.println(maximumImportance(5,
            matrix("[[0,3],[2,4],[1,3]]"))); // 20
        System.out.println(maximumImportance(5,
            matrix("[[0,1]]"))); // 9
        System.out.println(maximumImportance(8,
            matrix("[[1,0],[2,0],[3,0],[4,0],[5,1],[6,1],[7,1],[2,1]]"))); // 95
        System.out.println(maximumImportance(50000,
            matrix(loadTestcase("6085-testcase-1.txt")))); // 3750024997
    }

}
