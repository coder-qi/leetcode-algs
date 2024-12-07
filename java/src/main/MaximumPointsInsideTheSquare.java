import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import util.ArrayUtils;

/**
 * 3143. 正方形中的最多点数：https://leetcode.cn/problems/maximum-points-inside-the-square
 */
public class MaximumPointsInsideTheSquare {

    public static int maxPointsInsideSquare(int[][] points, String s) {
        int N = points.length;
        Info[] infoArr = new Info[N];
        for (int i = 0; i < N; i++) {
            infoArr[i] = new Info(points[i], i);
        }
        Arrays.sort(infoArr, (info1, info2) -> {
            return Integer.compare(info1.point, info2.point);
        });
        Set<Character> chs = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < N;) {
            if (!chs.add(s.charAt(infoArr[i].index))) {
                return ans;
            }
            int j = i + 1;
            while (j < N && infoArr[i].point == infoArr[j].point) {
                if (!chs.add(s.charAt(infoArr[j].index))) {
                    return ans;
                }
                j++;
            }
            ans += j - i;
            i = j;
        }
        return ans;
    }

    static class Info {
        int point;
        int index;

        public Info(int[] point, int index) {
            this.point = Math.max(Math.abs(point[0]), Math.abs(point[1]));
            this.index = index;
        }
    }

    public static void main(String[] args) {
        // 2
        System.out.println(
            maxPointsInsideSquare(ArrayUtils.matrix("[[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]]"),
                "abdca"));
        // 1
        System.out.println(
            maxPointsInsideSquare(ArrayUtils.matrix("[[1,1],[-2,-2],[-2,2]]"),
                "abb"));
    }

}
