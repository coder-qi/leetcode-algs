package team.spring2022;

import static util.ArrayUtils.array;
import static util.ArrayUtils.matrix;

/**
 * LCP 55. 采集果实：https://leetcode-cn.com/problems/PTXy4P/
 */
public class LCP55 {

    public static int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int result = 0;
        for (int i = 0; i < fruits.length; i++) {
            int type = fruits[i][0], num = fruits[i][1];
            result += time[type] * ((num + limit - 1) / limit);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getMinimumTime(array("[2,3,2]"), matrix("[[0,2],[1,4],[2,1]]"), 3)); // 10
        System.out.println(getMinimumTime(array("[1]"), matrix("[[0,3],[0,5]]"), 2)); // 5
    }

}
