/**
 * 953. 验证外星语词典：https://leetcode.cn/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAnAlienDictionary {

    public static boolean isAlienSorted(String[] words, String order) {
        int[] pos = new int[26];
        for (int i = 0; i < order.length(); i++) {
            pos[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1], w2 = words[i];
            int len1 = w1.length(), len2 = w2.length(), lim = Math.min(len1, len2);
            int cmp = 0;
            for (int j = 0; j < lim; j++) {
                if (pos[w1.charAt(j) - 'a'] != pos[w2.charAt(j) - 'a']) {
                    cmp = pos[w1.charAt(j) - 'a'] - pos[w2.charAt(j) - 'a'];
                    break;
                }
            }
            if (cmp > 0 || (cmp == 0 && len1 - len2 > 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // true
        System.out.println(isAlienSorted(new String[] {"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        // false
        System.out.println(isAlienSorted(new String[] {"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        // false;
        System.out.println(isAlienSorted(new String[] {"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

}
