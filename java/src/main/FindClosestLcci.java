/**
 * 面试题 17.11. 单词距离：https://leetcode.cn/problems/find-closest-lcci/
 */
public class FindClosestLcci {

    public static int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        int ans = n;
        int pos1 = -1, pos2 = -1;
        for (int i = 0; i < n; i++) {
            if (words[i].equals(word1)) {
                pos1 = i;
            } else if (words[i].equals(word2)) {
                pos2 = i;
            }
            if (pos1 != -1 && pos2 != -1) {
                ans = Math.min(ans, Math.abs(pos1 - pos2));
            }
        }
        return ans == n ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(findClosest(new String[] {"I","am","a","student","from","a","university","in","a","city"},
            "a", "student")); // 1
    }

}
