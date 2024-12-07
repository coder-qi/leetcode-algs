/**
 * 944. 删列造序：https://leetcode.cn/problems/delete-columns-to-make-sorted/
 */
public class DeleteColumnsToMakeSorted {

    public static int minDeletionSize(String[] strs) {
        int ans = 0, m = strs.length, n = strs[0].length();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minDeletionSize(new String[] {"cba","daf","ghi"})); // 1
        System.out.println(minDeletionSize(new String[] {"a","b"})); // 0
        System.out.println(minDeletionSize(new String[] {"zyx","wvu","tsr"})); // 3
    }

}
