import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1700. 无法吃午餐的学生数量：https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 */
public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {

    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        Deque<Integer> q = new ArrayDeque<>(n);
        for (int stu : students) {
            q.offer(stu);
        }
        for (int i = 0; i < n; i++) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int cur = q.poll();
                if (cur == sandwiches[i]) { // 队首的学生拿走三明治
                    break;
                } else { // 不能拿走队首的三明治，学生放到队尾
                    q.offer(cur);
                }
            }
            if (q.size() == size) { // 没有学生能拿走三明治
                break;
            }
        }
        return q.size();
    }

}
