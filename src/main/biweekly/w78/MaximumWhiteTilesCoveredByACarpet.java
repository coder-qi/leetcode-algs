package biweekly.w78;

import java.util.Arrays;
import java.util.Comparator;

import util.ArrayUtils;

/**
 * 6068. 毯子覆盖的最多白色砖块数：https://leetcode.cn/problems/maximum-white-tiles-covered-by-a-carpet/
 */
public class MaximumWhiteTilesCoveredByACarpet {

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(t -> t[0]));
        int n = tiles.length;
        int ans = 0, maxLen = 0;
        for (int i = 0, j = 0; i < n; i++) {
            // 毯子覆盖[i...j]
            while (j < n && tiles[j][1] - tiles[i][0] + 1 <= carpetLen) {
                maxLen += tiles[j][1] - tiles[j][0] + 1;
                j++;
            }
            if (j < n) { // 可能第j组瓷砖只覆盖了一部分
                ans = Math.max(ans, maxLen + Math.max(0, carpetLen + tiles[i][0] - tiles[j][0]));
            } else { // 最后一组瓷砖被覆盖了
                ans = Math.max(ans, maxLen);
            }
            maxLen -= tiles[i][1] - tiles[i][0] + 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        // 9
        System.out.println(new MaximumWhiteTilesCoveredByACarpet()
            .maximumWhiteTiles(ArrayUtils.matrix("[[1,5],[10,11],[12,18],[20,25],[30,32]]"), 10));
        // 2
        System.out.println(new MaximumWhiteTilesCoveredByACarpet()
            .maximumWhiteTiles(ArrayUtils.matrix("[[10,11],[1,1]]"), 2));
    }

}
