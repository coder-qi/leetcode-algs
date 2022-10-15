import java.util.ArrayList;
import java.util.List;

/**
 * 1441. 用栈操作构建数组：https://leetcode.cn/problems/build-an-array-with-stack-operations/
 */
public class BuildAnArrayWithStackOperations {

    public static void main(String[] args) {

    }

    public static List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 0, num = 1; i < target.length; num++) {
            ans.add("Push");
            if (target[i] != num) {
                ans.add("Pop");
            } else {
                i++;
            }
        }
        return ans;
    }

}
