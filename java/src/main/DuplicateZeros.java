import java.util.Arrays;

import static util.ArrayUtils.array;

/**
 * 1089. 复写零：https://leetcode.cn/problems/duplicate-zeros/
 */
public class DuplicateZeros {

    public static void duplicateZeros(int[] arr) {
        int n = arr.length;
        int top = 0, i = -1;
        while (top < n) {
            top += arr[++i] == 0 ? 2 : 1;
        }
        int j = n - 1;
        if (top == n + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j--] = arr[i];
            if (arr[i] == 0) {
                arr[j--] = arr[i];
            }
            i--;
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

        arr = array("[1,5,2,0,6,8,0,6,0]");
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr)); // [1, 5, 2, 0, 0, 6, 8, 0, 0]

        arr = array("[0,1,7,6,0,2,0,7]");
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr)); // [0, 0, 1, 7, 6, 0, 0, 2]
    }

}
