import java.util.Arrays;

import static util.ArrayUtils.matrix;

/**
 * 1640. 能否连接形成数组：https://leetcode.cn/problems/check-array-formation-through-concatenation/
 */
public class CheckArrayFormationThroughConcatenation {

    public static void main(String[] args) {
        System.out.println(canFormArray(new int[] {15,88}, matrix("[[88],[15]]"))); // true
        System.out.println(canFormArray(new int[] {49,18,16}, matrix("[[16,18,49]]"))); // false
        System.out.println(canFormArray(new int[] {91,4,64,78}, matrix("[[78],[4,64],[91]]"))); // true
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        int n = arr.length;
        for (int[] piece : pieces) {
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if (arr[i] == piece[0]) {
                    if (piece.length > n - i || !Arrays.equals(arr, i, i + piece.length,
                            piece, 0, piece.length)) {
                        return false;
                    }
                    found = true;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

}
