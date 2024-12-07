import java.util.Arrays;

/**
 * 691. 贴纸拼词：https://leetcode.cn/problems/stickers-to-spell-word/
 */
public class StickersToSpellWord {

    int m;
    int[] mem;
    String target;
    String[] stickers;

    public int minStickers(String[] stickers, String target) {
        this.stickers = stickers;
        this.target = target;
        m = target.length();
        mem = new int[1 << m];
        Arrays.fill(mem, -1);
        mem[0] = 0;
        int result = dp((1 << m) - 1);
        return result <= m ? result : -1;
    }

    private int dp(int mask) {
        if (mem[mask] != -1) {
            return mem[mask];
        }
        int result = m + 1;
        for (String sticker : stickers) {
            int[] cnt = new int[26];
            for (int i = 0; i < sticker.length(); i++) {
                cnt[sticker.charAt(i) - 'a']++;
            }
            int left = mask;
            for (int i = 0; i < m; i++) {
                if (((mask >> i) & 1) == 1 && cnt[target.charAt(i) - 'a'] > 0) {
                    left ^= 1 << i;
                    cnt[target.charAt(i) - 'a']--;
                }
            }
            if (left < mask) {
                result = Math.min(result, dp(left) + 1);
            }
        }
        mem[mask] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new StickersToSpellWord().minStickers(new String[] {"with","example","science"}, "thehat")); // 3
        System.out.println(new StickersToSpellWord().minStickers(new String[] {"notice","possible"}, "basicbasic")); // -1
    }

}
