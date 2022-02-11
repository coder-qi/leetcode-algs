import java.util.ArrayList;
import java.util.List;

/**
 * 组合：https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, result, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(int n, int k, List<List<Integer>> result,
        ArrayList<Integer> list, int index) {
        if (index == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = list.isEmpty() ? 0 : list.get(list.size() - 1); i < n; i++) {
            list.add(i + 1);
            dfs(n, k, result, list, index + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 1));
    }

}
