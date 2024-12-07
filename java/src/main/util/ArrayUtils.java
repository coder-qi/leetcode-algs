package util;

import java.util.Arrays;
import java.util.function.Function;

public class ArrayUtils {

    public static String print(char[][] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(Arrays.toString(arr[i]))
                .append(",\n");
        }
        if (arr.length != 0) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    public static String print(int[] nums, int len) {
        if (nums == null)
            return "null";
        int iMax = len - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < len; i++) {
            b.append(nums[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
        return b.toString();
    }

    public static String print(int[] nums) {
       return print(nums, nums.length);
    }

    public static String print(int[][] matrix) {
        return print(matrix, true);
    }

    public static String prints(int[][] matrix) {
        return print(matrix, false);
    }

    public static String print(int[][] matrix, boolean pretty) {
        if (matrix == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i])).append(',');
            if (pretty) {
                sb.append("\n");
            }
        }
        if (matrix.length != 0) {
            sb.setLength(sb.length() - (pretty ? 2 : 1));
        }
        sb.append("]");
        return sb.toString();
    }

    public static int[][] matrix(String s) {
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        if (s.isEmpty()) {
            return new int[][] {};
        }
        String[] items = s.split("\\]\\s*,\\s*");
        int[][] result = new int[items.length][];
        for (int i = 0; i < items.length; i++) {
            result[i] = array(items[i] + (i != items.length - 1 ? "]" : ""));
        }
        return result;
    }

    public static char[][] matrixChar(String s) {
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        String[] items = s.split("\\]\\s*,\\s*");
        char[][] result = new char[items.length][];
        for (int i = 0; i < items.length; i++) {
            result[i] = arrayChar(items[i] + (i != items.length - 1 ? "]" : ""));
        }
        return result;
    }

    public static char[] arrayChar(String s) {
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        String[] items = s.split("\\s*,\\s*");
        char[] result = new char[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = items[i].charAt(1);
        }
        return result;
    }

    public static int[] array(String s) {
        s = s.trim();
        s = s.substring(1, s.length() - 1);
        String[] items = s.split("\\s*,\\s*");
        int[] result = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            result[i] = Integer.parseInt(items[i]);
        }
        return result;
    }

}
