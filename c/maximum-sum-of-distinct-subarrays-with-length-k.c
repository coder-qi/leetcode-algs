/**
 * 2461. 长度为 K 子数组中的最大和：https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k
 */

#include <math.h>
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


long long maximumSubarraySum(int* nums, int numsSize, int k) {
    long long sum = 0;
    long long ans = 0;
    for (int i = 0; i < numsSize; i++) {
        MapItem *item = get(nums[i]);
        if (item == NULL) {
            put(nums[i], 1);
        } else {
            item->value++;
        }
        sum += nums[i];
        if (i + 1 < k) {
            continue;
        }
        if (size() == k) {
            ans = fmax(ans, sum);
        }

        int out = nums[i - k + 1];
        item = get(out);
        item->value--;
        if (item->value == 0) {
            remove_key(out);
        }
        sum -= out;
    }

    free_all();
    return ans;
}