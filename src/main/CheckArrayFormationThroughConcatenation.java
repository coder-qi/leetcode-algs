import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
        Map<Integer, Integer> pieceIndex = new HashMap<>();
        for (int i = 0; i < pieces.length; i++) {
            pieceIndex.put(pieces[i][0], i);
        }
        for (int i = 0; i < arr.length;) {
            int j = pieceIndex.getOrDefault(arr[i], -1);
            if (j == -1) {
                return false;
            }
            int[] piece = pieces[j];
            if (!Arrays.equals(arr, i, i + piece.length, piece, 0, piece.length)) {
                return false;
            }
            i += piece.length;
        }
        return true;
    }

}
