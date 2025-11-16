/**
 * 1456. 定长子串中元音的最大数目：https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length
 */

#include <stdio.h>

int maxVowels(char* s, int k);

int main()
{
    printf("%d\n", maxVowels("abciiidef", 3)); // 3
    printf("%d\n", maxVowels("aeiou", 2)); // 2
    printf("%d\n", maxVowels("leetcode", 3)); // 2
    printf("%d\n", maxVowels("rhythms", 4)); // 0
    printf("%d\n", maxVowels("tryhard", 4)); // 1
    printf("%d\n", maxVowels("weallloveyou", 7)); // 4
    return 0;
}

#define MAX(a, b) ((b) > (a) ? (b) : (a))

int maxVowels(char* s, int k) {
    int ans = 0;
    int count = 0;
    for (char *p = s, *q = s; *p != '\0'; p++) {
        if (*p == 'a' || *p == 'e' || *p == 'i' || *p == 'o' || *p == 'u') {
            count++;
        }
        if (p - q + 1 > k) {
            if (*q == 'a' || *q == 'e' || *q == 'i' || *q == 'o' || *q == 'u') {
                count--;
            }
            q++;
        }
        ans = MAX(ans, count);
        if (ans == k) {
            return ans;
        }
    }
    return ans;
}
