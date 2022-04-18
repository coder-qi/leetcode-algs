import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数：https://leetcode-cn.com/problems/lexicographical-numbers/
 */
public class LexicographicalNumbers {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1, j = Math.min(n, 9); i <= j; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    private static void dfs(int a, int n, List<Integer> result) {
        if (a > n) {
            return;
        }
        result.add(a);
        for (int i = 0; i <= 9; i++) {
            int b = a * 10 + i;
            if (b > n) {
                break;
            }
            dfs(b, n, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(13));
        System.out.println(lexicalOrder(2));
        System.out.println(lexicalOrder(50000));
    }

}
