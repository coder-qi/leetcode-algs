/**
 * 1590. 使数组和能被 P 整除：https://leetcode.cn/problems/make-sum-divisible-by-p
 */

#include <stdio.h>
#include <stdlib.h>
#include "uthash.h"

#define min(a,b) (((a) < (b)) ? (a) : (b))

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


int minSubarray(int* nums, int numsSize, int p) {
    long t = 0L;
    for (int i = 0; i < numsSize; i++) {
        t += nums[i];
    }
    if (t < p) {
        return -1;
    }
    const int k = t % p;
    if (k == 0) {
        return 0;
    }

    MapItem *last = NULL;
    int ans = numsSize;
    int s = 0;
    put(&last, s, -1);
    for (int i = 0; i < numsSize; i++) {
        s = (s + nums[i]) % p;
        put(&last, s, i);
        const MapItem * item = get(&last, (s - k + p) % p);
        const int j = item ? item->value : -numsSize;
        ans = min(ans, i - j);
    }
    free_all(&last);
    return ans < numsSize ? ans : -1;
}
