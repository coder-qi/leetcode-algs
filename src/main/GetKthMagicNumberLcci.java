import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 面试题 17.09. 第 k 个数：https://leetcode.cn/problems/get-kth-magic-number-lcci/
 */
public class GetKthMagicNumberLcci {

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(5)); // 9
        System.out.println(getKthMagicNumber(1000)); // 232
    }

    static List<Integer> list = new ArrayList<>(1000);
    static {
        for (long a = 1; a <= Integer.MAX_VALUE; a *= 3) {
            for (long b = 1; a * b <= Integer.MAX_VALUE; b *= 5) {
                for (long c = 1; a * b * c <= Integer.MAX_VALUE; c *= 7) {
                    list.add((int) (a * b * c));
                }
            }
        }
        Collections.sort(list);
    }

    public static int getKthMagicNumber(int k) {
        return list.get(k - 1);
    }

}
