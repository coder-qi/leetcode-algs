package weekly.w296;

import java.util.ArrayList;

/**
 * 6093. 设计一个文本编辑器：https://leetcode.cn/problems/design-a-text-editor/
 */
public class DesignATextEditor {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor(); // 当前 text 为 "|" 。（'|' 字符表示光标）
        textEditor.addText("leetcode"); // 当前文本为 "leetcode|" 。
        textEditor.deleteText(4); // 返回 4
        // 当前文本为 "leet|" 。
        // 删除了 4 个字符。
        textEditor.addText("practice"); // 当前文本为 "leetpractice|" 。
        textEditor.cursorRight(3); // 返回 "etpractice"
        // 当前文本为 "leetpractice|".
        // 光标无法移动到文本以外，所以无法移动。
        // "etpractice" 是光标左边的 10 个字符。
        textEditor.cursorLeft(8); // 返回 "leet"
        // 当前文本为 "leet|practice" 。
        // "leet" 是光标左边的 min(10, 4) = 4 个字符。
        textEditor.deleteText(10); // 返回 4
        // 当前文本为 "|practice" 。
        // 只有 4 个字符被删除了。
        textEditor.cursorLeft(2); // 返回 ""
        // 当前文本为 "|practice" 。
        // 光标无法移动到文本以外，所以无法移动。
        // "" 是光标左边的 min(10, 0) = 0 个字符。
        textEditor.cursorRight(6); // 返回 "practi"
        // 当前文本为 "practi|ce" 。
        // "practi" 是光标左边的 min(10, 6) = 6 个字符。
    }

    static class TextEditor {

        ArrayList<Character> left = new ArrayList<>(), right = new ArrayList<>();

        public TextEditor() {
        }

        public void addText(String text) {
            for (int i = 0; i < text.length(); i++) {
                left.add(text.charAt(i));
            }
        }

        public int deleteText(int k) {
            int p = k;
            while (k > 0 && !left.isEmpty()) {
                left.remove(left.size() - 1);
                k--;
            }
            return p - k;
        }

        String text() {
            StringBuilder result = new StringBuilder();
            for (int i = Math.max(0, left.size() - 10); i < left.size(); i++) {
                result.append(left.get(i));
            }
            return result.toString();
        }

        public String cursorLeft(int k) {
            while (k > 0 && !left.isEmpty()) {
                right.add(left.remove(left.size() - 1));
                k--;
            }
            return text();
        }

        public String cursorRight(int k) {
            while (k > 0 && !right.isEmpty()) {
                left.add(right.remove(right.size() - 1));
                k--;
            }
            return text();
        }
    }

}
