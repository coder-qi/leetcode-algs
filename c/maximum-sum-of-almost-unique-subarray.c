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

void put(int key, int value) {
    MapItem *item;
    HASH_FIND_INT(map, &key, item);
    if (item == NULL) {
        item = malloc(sizeof(MapItem));
        item->key = key;
        item->value = value;
        HASH_ADD_INT(map, key, item);
    } else {
        item->value = value;
    }
}

MapItem* get(int key) {
    MapItem *item;
    HASH_FIND_INT(map, &key, item);
    return item;
}

void remove_key(int key) {
    MapItem *item;
    HASH_FIND_INT(map, &key, item);
    if (item) {
        HASH_DEL(map, item);
        free(item);
    }
}

int size() {
    return HASH_COUNT(map);
}

void free_all() {
    MapItem *curr, *tmp;
    HASH_ITER(hh, map, curr, tmp) {
        HASH_DEL(map, curr);
        free(curr);
    }
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