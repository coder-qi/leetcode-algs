import java.util.ArrayList;
import java.util.List;

/**
 * 复原 IP 地址：https://leetcode-cn.com/problems/restore-ip-addresses/
 */
public class RestoreIpAddresses {

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(s, 0, result, list);
        return result;
    }

    private static void dfs(String s, int i, List<String> result, List<Integer> list) {
        if (list.size() == 4) {
            if (i == s.length()) {
                StringBuilder sb = new StringBuilder();
                for (Integer num : list) {
                    if (sb.length() > 0) {
                        sb.append('.');
                    }
                    sb.append(num);
                }
                result.add(sb.toString());
            }
            return;
        }
        if ((4 - list.size()) * 3 + i < s.length()) {
            return;
        }
        int sum = 0;
        for (int j = 1; j < 4; j++) {
            if ((j > 1 && s.charAt(i) == '0') || i + j > s.length()) {
                break;
            }
            sum = sum * 10 + (s.charAt(i + j - 1) - '0');
            if (sum <= 0xff) {
                list.add(sum);
                dfs(s, i + j, result, list);
                list.remove(list.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("172162541"));
    }

}
