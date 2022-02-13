import java.util.ArrayList;
import java.util.List;

/**
 * 子集：https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result,
        List<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1, 2, 3}));
        System.out.println(subsets(new int[] {0}));
    }

}
