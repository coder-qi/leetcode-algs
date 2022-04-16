import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 课程表：https://leetcode-cn.com/problems/course-schedule/
 */
public class CourseSchedule {

    List<Integer>[] edges;
    boolean[] marked;
    boolean[] onStack;
    boolean hasCycle;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
        }
        edges = new List[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        marked = new boolean[numCourses];
        onStack = new boolean[numCourses];
        for (int v = 0; v < numCourses; v++) {
            if (!marked[v]) {
                dfs(v);
            }
        }
        return !hasCycle;
    }

    private void dfs(int v) {
        if (edges[v] == null) {
            return;
        }
        onStack[v] = true;
        marked[v] = true;
        for (int w : edges[v]) {
            if (hasCycle) {
                return;
            }
            if (!marked[w]) {
                dfs(w);
            } else if (onStack[w]) {
                hasCycle = true;
            }
        }
        onStack[v] = false;
    }

    private void addEdge(int x, int y) {
        if (edges[x] == null) {
            edges[x] = new ArrayList<>();
        }
        edges[x].add(y);
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{
            {1,0}
        })); // true
        System.out.println(new CourseSchedule().canFinish(2, new int[][]{
            {1,0},
            {0,1}
        })); // false
        System.out.println(new CourseSchedule().canFinish(5, new int[][]{
            {1,4},{2,4},{3,1},{3,2}
        })); // true
    }

}
