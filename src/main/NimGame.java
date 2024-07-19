/**
 * 292. Nim 游戏：https://leetcode.cn/problems/nim-game
 */
public class NimGame {

    /*public static boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean first = true;
        boolean second = true;
        boolean third = true;
        for (int i = 3; i < n; i++) {
            boolean temp = third;
            third = !first || !second || !third;
            first = second;
            second = temp;
        }
        return third;
    }*/

    public static boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println((i + 1) + ":" + canWinNim(i + 1));
        }
    }

}
