import java.util.Arrays;

/**
 * 1700. 无法吃午餐的学生数量：https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/
 */
public class NumberOfStudentsUnableToEatLunch {

    public static void main(String[] args) {

    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int stu1 = Arrays.stream(students).sum(), stu0 = n - stu1;
        for (int i = 0; i < n; i++) {
            if (sandwiches[i] == 0 && stu0 > 0) { // 还有能拿走圆形三明治的学生
                stu0--;
            } else if (sandwiches[i] == 1 && stu1 > 0) { // 还有能拿走方形三明治的学生
                stu1--;
            } else { // 当前的三明治不能被任何一个学生拿走
                break;
            }
        }
        return stu0 + stu1;
    }

}
