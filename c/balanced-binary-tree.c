/**
 * 110. 平衡二叉树：https://leetcode.cn/problems/balanced-binary-tree
 */

#include <math.h>
#include <stdbool.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

#define MAX(a, b) ((a) > (b) ? (a) : (b))

int dfs(struct TreeNode* node, bool *balanced) {
    if (!node) {
        return 0;
    }
    int leftHeight = dfs(node->left, balanced);
    int rightHeight = dfs(node->right, balanced);
    if (abs(leftHeight - rightHeight) > 1) {
        *balanced = false;
    }
    return 1 + MAX(leftHeight, rightHeight);
}

bool isBalanced(struct TreeNode* root) {
    bool balanced = true;
    dfs(root, &balanced);
    return balanced;
}