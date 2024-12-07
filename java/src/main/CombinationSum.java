import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和：https://leetcode-cn.com/problems/combination-sum/
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private static void dfs(List<List<Integer>> ans, int[] candidates,
            int target, List<Integer> combine, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int k = target - candidates[i];
            if (k >= 0) {
                combine.add(candidates[i]);
                dfs(ans, candidates, k, combine, i);
                combine.remove(combine.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7)); // [[2,2,3],[7]]
        System.out.println(combinationSum(new int[] {2,3,5}, 8)); // [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println(combinationSum(new int[] {2}, 1)); // []
        System.out.println(combinationSum(new int[] {1}, 1)); // [1]
        System.out.println(combinationSum(new int[] {1}, 2)); // [[1,1]]
    }

}
