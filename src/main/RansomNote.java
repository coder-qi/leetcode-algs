/**
 * 383. 赎金信：https://leetcode.cn/problems/ransom-note/description/?envType=daily-question&envId=2024-01-07
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int idx = ransomNote.charAt(i) - 'a';
            if (count[idx] != 0) {
                count[idx]--;
            } else {
                return false;
            }
        }
        return true;
    }

}
