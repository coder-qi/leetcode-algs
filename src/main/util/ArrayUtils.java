package util;

public class ArrayUtils {

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

}
