import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角 II：https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class PascalsTriangleII {

    public static List<Integer> getRow(int rowIndex) {
        Integer[] nums = new Integer[rowIndex + 1];
        Arrays.fill(nums, 1);
        for (int i = 2; i <= rowIndex; i++) {
            int p = 1;
            for (int j = 1; j < i; j++) {
                int t = nums[j];
                nums[j] += p;
                p = t;
            }
        }
        return Arrays.asList(nums);
    }

    public static void main(String[] args) {
        System.out.println(getRow(3)); // [1, 3, 3, 1]
        System.out.println(getRow(0)); // [1]
        System.out.println(getRow(4)); // [1, 4, 6, 4, 1]
    }

}
