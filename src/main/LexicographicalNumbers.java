import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数：https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < n; i++) {
            result.add(num);
            if (num * 10 <= n) {
                num *= 10;
            } else {
                while (num % 10 == 9 || num + 1 > n) {
                    num /= 10;
                }
                num++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
        System.out.println(lexicalOrder(2));
        System.out.println(lexicalOrder(50000));
    }

}
