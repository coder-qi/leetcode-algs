import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 1089. 复写零：https://leetcode.cn/problems/duplicate-zeros/
 */
public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 && i + 1 < n) {
                System.arraycopy(arr, i + 1, arr, i + 2, n - i - 2);
                arr[++i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = array("[1,0,2,3,0,4,5,0]");
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr)); // [1,0,0,2,3,0,0,4]

        arr = array("[1,2,3]");
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr)); // [1,2,3]

        arr = array("[8,4,5,0,0,0,0,7]");
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr)); // [1,2,3]
    }

}
