/**
 * 717. 1 比特与 2 比特字符：https://leetcode.cn/problems/1-bit-and-2-bit-characters/
 */

#include <stdbool.h>

bool isOneBitCharacter(int *bits, int bitsSize) {
    if (bits[bitsSize - 1] == 1)
        return false;
    for (int i = 0; i < bitsSize - 1; ++i) {
        if (bits[i] == 1) {
            if (i + 1 >= bitsSize - 1)
                return false;
            ++i;
        }
    }
    return true;
}
