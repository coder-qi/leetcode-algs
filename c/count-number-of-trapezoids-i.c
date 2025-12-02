/**
 * 3623. 统计梯形的数目 I：https://leetcode.cn/problems/count-number-of-trapezoids-i
 */


#include <stdio.h>
#include <stdlib.h>
#include "uthash.h"

#define MOD 1000000007

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

static void free_all(MapItem **map) {
    MapItem *curr, *tmp;
    HASH_ITER(hh, *map, curr, tmp) {
        HASH_DEL(*map, curr);
        free(curr);
    }
}

int countTrapezoids(int** points, int pointsSize, int* pointsColSize) {
    MapItem *cnt = NULL;
    for (int i = 0; i < pointsSize; ++i) {
        MapItem *item = get(&cnt, points[i][1]);
        if (item) {
            item->value++;
        } else {
            put(&cnt, points[i][1], 1);
        }
    }

    long long ans = 0, s = 0;
    MapItem *item, *tmp;
    HASH_ITER(hh, cnt, item, tmp) {
        int c = item->value;
        long long k = (long long)c * (c - 1) / 2;
        ans += s * k;
        s += k;
    }
    free_all(&cnt);
    return ans % MOD;
}
