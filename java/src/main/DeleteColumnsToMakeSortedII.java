import java.util.ArrayList;
import java.util.List;

/**
 * 955. 删列造序 II：https://leetcode.cn/problems/delete-columns-to-make-sorted-ii
 */
public class DeleteColumnsToMakeSortedII {

    public int minDeletionSize(String[] strs) {
        List<int[]> groups = new ArrayList<>();
        int n = strs.length;
        int m = strs[0].length();
        groups.add(new int[] {0, n - 1});
        int ans = 0;
        for (int column = 0; column < m; column++) {
            List<int[]> nextGroups = new ArrayList<>();
            boolean deleted = false;
            for (int[] group : groups) {
                int start = group[0], end = group[1];
                if (start == end) {
                    continue;
                }
                char prevCh = 0;
                for (int i = start; i <= end;) {
                    if (prevCh > strs[i].charAt(column)) {
                        deleted = true;
                        break;
                    }
                    int j = i;
                    while (j + 1 <= end && strs[j].charAt(column) == strs[j + 1].charAt(column)) {
                        j++;
                    }
                    prevCh = strs[i].charAt(column);
                    nextGroups.add(new int[] {i, j});
                    i = j + 1;
                }
                if (deleted) {
                    break;
                }
            }
            if (deleted) {
                ans++;
            } else {
                groups = nextGroups;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSortedII app = new DeleteColumnsToMakeSortedII();
        System.out.println(app.minDeletionSize(new String[] {"xga","xfb","yfa"}));
        System.out.println(app.minDeletionSize(new String[] {"zyx","wvu","tsr"}));
        System.out.println(app.minDeletionSize(new String[] {"vdy","vei","zvc","zld"}));
        System.out.println(app.minDeletionSize(new String[] {"ousnatait","xzswvwztr","luknznxob"}));
    }

}
