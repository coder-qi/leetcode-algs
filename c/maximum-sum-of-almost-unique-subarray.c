/**
 * 2841. 几乎唯一子数组的最大和：https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray
 */

#include <stdio.h>
#include <stdlib.h>
#include "uthash.h"

typedef struct {
    int key;
    int value;
    UT_hash_handle hh;
} MapItem;

MapItem *map = NULL;
int map_size = 0;   // 自己维护 size

// 插入或更新
void put(int key, int value) {
    MapItem *item;
    HASH_FIND_INT(map, &key, item);

    if (item == NULL) {            // 新节点
        item = malloc(sizeof(MapItem));
        item->key = key;
        item->value = value;
        HASH_ADD_INT(map, key, item);
        map_size++;                // 手动 ++
    } else {
        item->value = value;       // 更新
    }
}

// 查找
MapItem* get(int key) {
    MapItem *item;
    HASH_FIND_INT(map, &key, item);
    return item;
}

// 删除
void remove_key(int key) {
    MapItem *item;
    HASH_FIND_INT(map, &key, item);
    if (item) {
        HASH_DEL(map, item);
        free(item);
        map_size--;                // 手动 --
    }
}

// O(1) size
int size() {
    return map_size;
}

// 清空
void free_all() {
    MapItem *curr, *tmp;
    HASH_ITER(hh, map, curr, tmp) {
        HASH_DEL(map, curr);
        free(curr);
    }
    map_size = 0;
}

long long maxSum(int* nums, int numsSize, int m, int k) {
    long long ans = 0;
    long long sum = 0;
    for (int i = 0; i < numsSize; i++) {
        sum += nums[i];
        MapItem *c = get(nums[i]);
        if (c) {
            c->value++;
        } else {
            put(nums[i], 1);
        }
        if (i + 1 < k) {
            continue;
        }
        if (size() >= m) {
            ans = sum > ans ? sum : ans;
        }
        int last = nums[i - k + 1];
        sum -= last;
        c = get(last);
        if (c->value == 1) {
            remove_key(last);
        } else {
            c->value--;
        }
    }

    free_all();
    return ans;
}