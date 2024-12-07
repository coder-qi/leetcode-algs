import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 593. 有效的正方形：https://leetcode.cn/problems/valid-square/
 */
public class ValidSquare {

    public static void main(String[] args) {
        System.out.println(validSquare(array("[0,0]"), array("[1,1]"),
            array("[1,0]"), array("[0,1]"))); // true
        System.out.println(validSquare(array("[0,0]"), array("[1,1]"),
            array("[1,0]"), array("[0,12]"))); // false
        System.out.println(validSquare(array("[1,0]"), array("[-1,0]"),
            array("[0,1]"), array("[0,-1]"))); // true
    }

    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p4, p2, p3);
    }

    private static boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (Arrays.equals(p1, p2)) {
            return false;
        }
        int vx1 = p1[0] - p2[0], vy1 = p1[1] - p2[1],
            vx2 = p3[0] - p4[0], vy2 = p3[1] - p4[1];
        // 中点要相同
        if ((p1[0] + p2[0]) != (p3[0] + p4[0]) || (p1[1] + p2[1]) != (p3[1] + p4[1])) {
            return false;
        }
        // 斜边长度要相同
        if ((vx1 * vx1 + vy1 * vy1) != (vx2 * vx2 + vy2 * vy2)) {
            return false;
        }
        // 两条边垂直
        if ((vx1 * vx2 + vy1 * vy2) != 0) {
            return false;
        }
        return true;
    }

}
