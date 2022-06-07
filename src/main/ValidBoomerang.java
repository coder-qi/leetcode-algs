import static util.ArrayUtils.matrix;

/**
 * 1037. 有效的回旋镖：https://leetcode.cn/problems/valid-boomerang/
 */
public class ValidBoomerang {

    public static boolean isBoomerang(int[][] points) {
        int x1 = points[1][0] - points[0][0], y1 = points[1][1] - points[0][1];
        int x2 = points[2][0] - points[1][0], y2 = points[2][1] - points[1][1];
        return x1 * y2 - x2 * y1 != 0;
    }

    public static void main(String[] args) {
        System.out.println(isBoomerang(matrix("[[1,1],[2,3],[3,2]]"))); // true
        System.out.println(isBoomerang(matrix("[[1,1],[2,2],[3,3]]"))); // false
    }

}
