import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 杨辉三角：https://leetcode-cn.com/problems/pascals-triangle/
 */
public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prev = result.get(i - 1);

            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(prev.get(j - 1) + prev.get(j));
            }
            list.add(1);

            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(30));
    }

}
