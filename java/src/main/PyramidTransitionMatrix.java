import java.util.*;

/**
 * 756. 金字塔转换矩阵：https://leetcode.cn/problems/pyramid-transition-matrix
 */
public class PyramidTransitionMatrix {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Set<Integer>[] allowMap = new Set[36];
        for (int i = 0; i < 36; i++) {
            allowMap[i] = new HashSet<>();
        }
        for (String s : allowed) {
            int a = s.charAt(0) - 'A';
            int b = (s.charAt(1) - 'A') * 6;
            int c = (s.charAt(2) - 'A') * 36;
            allowMap[a + b].add(a + b + c);
        }
        int[] nums = new int[bottom.length()];
        for (int i = 0; i < bottom.length(); i++) {
            nums[i] = bottom.charAt(i) - 'A';
        }
        return process(nums, nums.length, allowMap);
    }

    private boolean process(int[] nums, int len, Set<Integer>[] allowMap) {
        if (len == 1) {
            return true;
        }
        List<Set<Integer>> next = new ArrayList<>(nums.length);
        for (int i = 0; i < len - 1; i++) {
            int a = nums[i];
            int b = nums[i + 1] * 6;
            if (allowMap[a + b].isEmpty()) {
                return false;
            }
            next.add(allowMap[a + b]);
        }
        return next(next, nums, 0, len - 1, allowMap);
    }

    private boolean next(List<Set<Integer>> next, int[] nums, int i, int len, Set<Integer>[] allowMap) {
        if (i == next.size()) {
            return process(nums, len, allowMap);
        }
        boolean res = false;
        for (int x : next.get(i)) {
            nums[i] = x / 36;
            if (i > 0) {
                int a = nums[i - 1];
                int b = nums[i] * 6;
                if (allowMap[a + b].isEmpty()) {
                    continue;
                }
            }
            res = next(next, nums, i + 1, len, allowMap);
            if (res) {
                return true;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PyramidTransitionMatrix app = new PyramidTransitionMatrix();
        System.out.println(app.pyramidTransition("BCD", Arrays.asList("BCC","CDE","CEA","FFF")));
    }

}
