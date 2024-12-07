import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 课程表：https://leetcode-cn.com/problems/course-schedule/
 */
public class CourseSchedule {

    List<Integer>[] edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length <= 1) {
            return true;
        }
        edges = new List[numCourses];
        indeg = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            addEdge(prerequisites[i][1], prerequisites[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        int visited = 0;
        while (!q.isEmpty()) {
            visited++;
            int u = q.poll();
            if (edges[u] != null) {
                for (int v : edges[u]) {
                    indeg[v]--;
                    if (indeg[v] == 0) {
                        q.offer(v);
                    }
                }
            }
        }
        return visited == numCourses;
    }

    private void addEdge(int x, int y) {
        if (edges[x] == null) {
            edges[x] = new ArrayList<>();
        }
        indeg[y]++;
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
        System.out.println(new CourseSchedule().canFinish(3, new int[][]{
            {1,0},
            {0,1},
            {1,2}
        })); // false
    }

}
