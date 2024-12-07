import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  全排列 II：https://leetcode-cn.com/problems/permutations-ii/
 */
public class PermutationsII {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        backtrace(nums, result, 0, vis, new ArrayList<Integer>());
        return result;
    }

    private static void backtrace(int[] nums, List<List<Integer>> result,
        int idx, boolean[] vis, ArrayList<Integer> perm) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i - 1] == nums[i] && !vis[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;

            backtrace(nums, result, idx + 1, vis, perm);

            vis[i] = false;
            perm.remove(idx);
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[] {1,1,2})); // [[1,1,2],[1,2,1],[2,1,1]]
        System.out.println(permuteUnique(new int[] {1,2,3})); // [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(permuteUnique(new int[] {2,2,1,1})); // [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
    }

}
