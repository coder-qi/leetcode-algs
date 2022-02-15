/**
 * 单词搜索：https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = word.charAt(0);
                if (c == board[i][j]) {

                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, int row, int column, int wordIndex) {
        for (int i = row; i < board.length; i++) {
            for (int j = column; j < board[i].length; j++) {
                char c = word.charAt(wordIndex);
                if (c == board[i][j]) {

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED")); // true
    }

}
