import java.util.Set;

/**
 * 1980. 找出不同的二进制字符串：https://leetcode.cn/problems/find-unique-binary-string
 */
public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> s = Set.of(nums);
        return dfs(n, new StringBuilder(n), s);
    }

    private String dfs(int i, StringBuilder sb, Set<String> s) {
        if (i == 0) {
            if (!s.contains(sb.toString())) {
                return sb.toString();
            }
            return null;
        }
        for (int j = 0; j <= 1; j++) {
            sb.append((char)('0' + j));
            String res = dfs(i - 1, sb, s);
            if (res != null) {
                return res;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return null;
    }

    public static void main(String[] args) {
        FindUniqueBinaryString app = new FindUniqueBinaryString();
        System.out.println(app.findDifferentBinaryString(new String[] {"1001","1000","0110","1111"}));
    }

}
