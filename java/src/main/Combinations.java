import java.util.ArrayList;
import java.util.List;

/**
 * 组合：https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>(k + 1);
        for (int i = 1; i <= k; i++) {
            temp.add(i);
        }
        temp.add(n + 1);
        int j = 0;
        while (j < k) {
            result.add(new ArrayList<>(temp.subList(0, k)));
            j = 0;
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                j++;
            }
            temp.set(j, temp.get(j) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 1));
    }

}
