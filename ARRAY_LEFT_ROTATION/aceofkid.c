#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char** split_string(char*);

// #define LOCAL_TEST
#define USE_MEM_COPY

static FILE *s_fp = NULL;

int main()
{
#if defined(LOCAL_TEST)
    s_fp = fopen("input.txt", "r");
#endif /* LOCAL_TEST */

    char** nd = split_string(readline());

    char* n_endptr;
    char* n_str = nd[0];
    int n = strtol(n_str, &n_endptr, 10);

    if (n_endptr == n_str || *n_endptr != '\0') { exit(EXIT_FAILURE); }

    char* d_endptr;
    char* d_str = nd[1];
    int d = strtol(d_str, &d_endptr, 10);

    if (d_endptr == d_str || *d_endptr != '\0') { exit(EXIT_FAILURE); }

    char** a_temp = split_string(readline());

    int* a = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        char* a_item_endptr;
        char* a_item_str = *(a_temp + i);
        int a_item = strtol(a_item_str, &a_item_endptr, 10);

        if (a_item_endptr == a_item_str || *a_item_endptr != '\0') { exit(EXIT_FAILURE); }

        *(a + i) = a_item;
    }

#if defined(USE_MEM_COPY)
    if (d != n) {
        int* rotatedArray = malloc(n * sizeof(int));
        memcpy(rotatedArray, a + d, (n - d) * sizeof(int));
        memcpy(rotatedArray + n - d, a, d * sizeof(int));

        for (int i = 0; i < n; i++) {
            printf("%d ", rotatedArray[i]);
        }
    } else {
        for (int i = 0; i < n; i++) {
            printf("%d ", a[i]);
        }
    }
    printf("\n");
#else /* USE_MEM_COPY */
    if (d != n) {
        for (int i = d; i < n; i++) {
            printf("%d ", a[i]);
        }

        for (int i = 0; i < d; i++) {
            printf("%d ", a[i]);
        }
    } else {
        for (int i = 0; i < n; i++) {
            printf("%d ", a[i]);
        }
    }
    printf("\n");
#endif /* !USE_MEM_COPY */

    free(a);

    return 0;
}

char* readline() {
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char* data = malloc(alloc_length);

    while (true) {
        char* cursor = data + data_length;
#if defined(LOCAL_TEST)
        char* line = fgets(cursor, alloc_length - data_length, s_fp);
#else  /* LOCAL_TEST */
        char* line = fgets(cursor, alloc_length - data_length, stdin);
#endif /* !LOCAL_TEST */

        if (!line) { break; }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') { break; }

        size_t new_length = alloc_length << 1;
        data = realloc(data, new_length);

        if (!data) { break; }

        alloc_length = new_length;
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';
    }

    data = realloc(data, data_length);

    return data;
}

char** split_string(char* str) {
    char** splits = NULL;
    char* token = strtok(str, " ");

    int spaces = 0;

    while (token) {
        splits = realloc(splits, sizeof(char*) * ++spaces);
        if (!splits) {
            return splits;
        }

        splits[spaces - 1] = token;

        token = strtok(NULL, " ");
    }

    return splits;
}
