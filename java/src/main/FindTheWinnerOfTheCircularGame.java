/**
 * 1823. 找出游戏的获胜者：https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 */
public class FindTheWinnerOfTheCircularGame {

    public static int findTheWinner(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; i++) {
            winner = (k + winner - 1) % i + 1;
        }
        return winner;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2)); // 3
        System.out.println(findTheWinner(6, 5)); //1
    }

}
