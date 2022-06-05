package weekly.w296;

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

        StringBuilder text = new StringBuilder();
        int cur = 0;

        public TextEditor() {
        }

        public void addText(String text) {
            this.text.insert(cur, text);
            cur += text.length();
        }

        public int deleteText(int k) {
            int begin = Math.max(0, cur - k);
            text.delete(begin, cur);
            int len = cur - begin;
            cur = begin;
            return len;
        }

        public String cursorLeft(int k) {
            cur = Math.max(0, cur - k);
            return text.substring(Math.max(0, cur - 10), cur);
        }

        public String cursorRight(int k) {
            cur = Math.min(text.length(), cur + k);
            return text.substring(Math.max(0, cur - 10), cur);
        }
    }

}
