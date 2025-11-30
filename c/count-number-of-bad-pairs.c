/**
 * 2364. 统计坏数对的数目：https://leetcode.cn/problems/count-number-of-bad-pairs
 */


#include <stdio.h>
#include <stdlib.h>
#include "uthash.h"

typedef struct {
    int key;
    int value;
    UT_hash_handle hh;
} MapItem;

static void put(MapItem **map, int key, int value) {
    MapItem *item;
    HASH_FIND_INT(*map, &key, item);
    if (item == NULL) {
        item = malloc(sizeof(MapItem));
        item->key = key;
        item->value = value;
        HASH_ADD_INT(*map, key, item);
    } else {
        item->value = value;
    }
}

static MapItem* get(MapItem **map, int key) {
    MapItem *item;
    HASH_FIND_INT(*map, &key, item);
    return item;
}

static void remove_key(MapItem **map, int key) {
    MapItem *item;
    HASH_FIND_INT(*map, &key, item);
    if (item) {
        HASH_DEL(*map, item);
        free(item);
    }
}

static int size(const MapItem **map) {
    return HASH_COUNT(*map);
}

static void free_all(MapItem **map) {
    MapItem *curr, *tmp;
    HASH_ITER(hh, *map, curr, tmp) {
        HASH_DEL(*map, curr);
        free(curr);
    }
}


long long countBadPairs(int* nums, int numsSize) {
    MapItem *cnt = NULL;
    long long ans = 0;
    for (int i = 0; i < numsSize; i++) {
        MapItem * item = get(&cnt, nums[i] - i);
        ans += i - (item ? item->value : 0);
        if (item) {
            item->value++;
        } else {
            put(&cnt, nums[i] - i, 1);
        }
    }
    free_all(&cnt);
    return ans;
}