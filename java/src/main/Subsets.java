import java.util.ArrayList;
import java.util.List;

/**
 * 子集：https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            list.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    list.add(nums[i]);
                }
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1, 2, 3}));
        System.out.println(subsets(new int[] {0}));
    }

}
