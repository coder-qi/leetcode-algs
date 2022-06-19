import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import util.TreeNode;

/**
 * 508. 出现次数最多的子树元素和：https://leetcode.cn/problems/most-frequent-subtree-sum/
 */
public class MostFrequentSubtreeSum {

    public static int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxCount = Math.max(maxCount, entry.getValue());
        }
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (maxCount == entry.getValue()) {
                list.add(entry.getKey());
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private static int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int sum = root.val + dfs(root.left, map) + dfs(root.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findFrequentTreeSum(TreeNode.of(5,2,-3))));
    }

}
