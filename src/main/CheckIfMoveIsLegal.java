/**
 * 1958. 检查操作是否合法：https://leetcode.cn/problems/check-if-move-is-legal/
 */
public class CheckIfMoveIsLegal {

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[] steps = new int[] {0, 1, -1};
        for (int rowStep : steps) {
            for (int columnStep : steps) {
                if (rowStep == 0 && columnStep == 0) {
                    continue;
                }
                if (isGoodLine(board, rMove, cMove, color, new int[] {rowStep, columnStep})) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isGoodLine(char[][] board, int rMove, int cMove, char color, int[] dir) {
        int M = board.length;
        int N = board[0].length;
        int row = rMove + dir[0];
        int column = cMove + dir[1];
        int count = 1;
        boolean isEnd = false;
        while (row >= 0 && row < M && column >= 0 && column < N) {
            char currentColor = board[row][column];
            if (currentColor == '.') {
                return false;
            }
            count++;
            if (currentColor != color) {
                row += dir[0];
                column += dir[1];
            } else {
                isEnd = true;
                break;
            }
        }
        return isEnd && count >= 3;
    }

}
