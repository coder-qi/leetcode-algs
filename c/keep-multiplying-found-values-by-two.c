/**
 * 2154. 将找到的值乘以 2：https://leetcode.cn/problems/keep-multiplying-found-values-by-two
 */

#include <stdbool.h>
#include <stdlib.h>

typedef struct {
    int key;
    UT_hash_handle hh;
} HashItem;

HashItem *hashFindItem(HashItem **obj, int key) {
    HashItem *pEntry = NULL;
    HASH_FIND_INT(*obj, &key, pEntry);
    return pEntry;
}

bool hashAddItem(HashItem **obj, int key) {
    if (hashFindItem(obj, key)) {
        return false;
    }
    HashItem *pEntry = (HashItem *)malloc(sizeof(HashItem));
    pEntry->key = key;
    HASH_ADD_INT(*obj, key, pEntry);
    return true;
}

void hashFree(HashItem **obj) {
    HashItem *curr = NULL, *tmp = NULL;
    HASH_ITER(hh, *obj, curr, tmp) {
        HASH_DEL(*obj, curr);
        free(curr);
    }
}

int findFinalValue(int* nums, int numsSize, int original) {
    HashItem *set = NULL;
    for (int i = 0; i < numsSize; ++i) {
        hashAddItem(&set, nums[i]);
    }
    while (hashFindItem(&set, original)) {
        original *= 2;
    }
    hashFree(&set);
    return original;
}