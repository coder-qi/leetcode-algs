import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集 II：https://leetcode-cn.com/problems/subsets-ii/
 */
public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list, result);
        return result;
    }

    private static void dfs(int[] nums, int i, List<Integer> list,
        List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        if (i == nums.length) {
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            list.add(nums[j]);
            dfs(nums, j + 1, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[] {1,2,2}));
    }

}
