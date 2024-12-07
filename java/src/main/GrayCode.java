import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码：https://leetcode-cn.com/problems/gray-code/
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        int max = 1 << n;
        List<Integer> result = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2)); // 0,1,3,2
        System.out.println(new GrayCode().grayCode(1)); // 0,1
        System.out.println(new GrayCode().grayCode(3)); // 0, 1, 3, 2, 6, 7, 5, 4
    }

}
