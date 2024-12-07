import java.util.ArrayList;
import java.util.List;

/**
 * 全排列：https://leetcode-cn.com/problems/permutations/
 */
public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, result, new ArrayList<>(nums.length));
        return result;
    }

    private static void dfs(int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, result, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3})); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(permute(new int[] {0,1})); // [[0,1],[1,0]]
        System.out.println(permute(new int[] {1})); // [[1]]
    }

}
