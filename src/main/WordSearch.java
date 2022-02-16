/**
 * 单词搜索：https://leetcode-cn.com/problems/word-search/
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean search(char[][] board, String word, int row, int column, int wordIndex, boolean[][] visited) {
        if (wordIndex >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length
            || visited[row][column] || board[row][column] != word.charAt(wordIndex)) {
            return false;
        }
        visited[row][column] = true;
        boolean result = search(board, word, row + 1, column, wordIndex + 1, visited)
            || search(board, word, row - 1, column, wordIndex + 1, visited)
            || search(board, word, row, column + 1, wordIndex + 1, visited)
            || search(board, word, row, column - 1, wordIndex + 1, visited);
        visited[row][column] = false;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE")); // true
        System.out.println(exist(board, "ABCB")); // false
        char[][] board2 = {{'a','b'},{'c','d'}};
        System.out.println(exist(board2, "acdb"));
    }

}
