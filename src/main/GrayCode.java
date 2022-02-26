import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码：https://leetcode-cn.com/problems/gray-code/
 */
public class GrayCode {

    List<Integer> result;
    int n;
    int max;
    boolean[] vis;

    public List<Integer> grayCode(int n) {
        this.n = n;
        max = 1 << n;
        result = new ArrayList<>(max);
        vis = new boolean[max];
        dfs(0);
        return result;
    }

    private boolean dfs(int cur) {
        if (result.size() == max) {
            return true;
        }
        result.add(cur);
        vis[cur] = true;
        for (int j = 0; j < n; j++) {
            int num = (1 << j) ^ cur;
            if (!vis[num] && dfs(num)) {
                return true;
            }
        }
        vis[cur] = false;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new GrayCode().grayCode(2)); // 0,1,3,2
        System.out.println(new GrayCode().grayCode(1)); // 0,1
        System.out.println(new GrayCode().grayCode(3)); // 0, 1, 3, 2, 6, 7, 5, 4
    }

}
