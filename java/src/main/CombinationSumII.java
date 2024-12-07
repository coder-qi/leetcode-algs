import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和 II：https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        int left = index;
        while (left < candidates.length) {
            int k = target - candidates[left];
            if (k >= 0) {
                combine.add(candidates[left]);
                dfs(ans, candidates, k, combine, left + 1);
                combine.remove(combine.size() - 1);
            } else {
                break;
            }

            int right = left + 1;
            while (right < candidates.length && candidates[left] == candidates[right]) {
                right++;
            }
            left = right;
        }
    }

    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        /*[
        [1,1,6],
        [1,2,5],
        [1,7],
        [2,6]
        ]*/
        System.out.println(combinationSum2(new int[] {2,5,2,1,2}, 5));
        /*[
        [1,2,2],
        [5]
        ]*/
        System.out.println(combinationSum2(new int[] {1, 1}, 1));
    }

}
