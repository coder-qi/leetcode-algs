/**
 * 2872. 可以被 K 整除连通块的最大数目：https://leetcode.cn/problems/maximum-number-of-k-divisible-components
 */

#include <stdlib.h>

typedef struct Node {
    int to;
    struct Node *next;
} Node;

static void addEdge(Node **g, int u, int v) {
    Node *node = malloc(sizeof(struct Node));
    node->to = v;
    node->next = g[u];
    g[u] = node;
}

int dfs(int u, int fa, Node **g, int* values, int k, int *ans) {
    int x = values[u] % k;
    for (Node *e = g[u]; e; e = e->next) {
        int v = e->to;
        if (v != fa) {
            x = (x + dfs(v, u, g, values, k, ans)) % k;
        }
    }
    if (x == 0) {
        (*ans)++;
    }
    return x;
}

int maxKDivisibleComponents(int n, int** edges, int edgesSize, int* edgesColSize, int* values, int valuesSize, int k) {
    Node **g = calloc(n, sizeof(Node*));
    for (int i = 0; i < edgesSize; i++) {
        const int a = edges[i][0];
        const int b = edges[i][1];
        addEdge(g, a, b);
        addEdge(g, b, a);
    }
    int ans = 0;
    dfs(0, -1, g, values, k, &ans);
    for (int i = 0; i < n; i++) {
        Node *e = g[i];
        while (e) {
            Node *next = e->next;
            free(e);
            e = next;
        }
    }
    free(g);
    return ans;
}

