/**
 * 2211. 统计道路上的碰撞次数：https://leetcode.cn/problems/count-collisions-on-a-road
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int countCollisions(char* directions) {
    int n = strlen(directions);
    char *stack = malloc(sizeof(char) * n);
    int si = 0;
    int ans = 0;
    for (int i = 0; i < n; i++) {
        char d = directions[i];

        if (d == 'L') {
            if (si > 0) {
                ans += stack[si - 1] == 'R' ? 2 : 1;
                si--;
                d = 'S';
            }
        } else if (d == 'R') {
            stack[si++] = d;
        }

        if (d == 'S') {
            if (si > 0) {
                ans += si;
                if (stack[0] == 'S') {
                    ans--;
                }
                si = 0;
            }
            stack[si++] = d;
        }
    }
    free(stack);
    return ans;
}

int main(int argc, char *argv[]) {
    printf("%d\n", countCollisions("LLRLRLLSLRLLSLSSSS"));
}
