#include <assert.h>
#include <ctype.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* readline();
char* ltrim(char*);
char* rtrim(char*);
char** split_string(char*);

// Complete the dynamicArray function below.

/*
 * To return the integer array from the function, you should:
 *     - Store the size of the array to be returned in the result_count variable
 *     - Allocate the array statically or dynamically
 *
 * For example,
 * int* return_integer_array_using_static_allocation(int* result_count) {
 *     *result_count = 5;
 *
 *     static int a[5] = {1, 2, 3, 4, 5};
 *
 *     return a;
 * }
 *
 * int* return_integer_array_using_dynamic_allocation(int* result_count) {
 *     *result_count = 5;
 *
 *     int *a = malloc(5 * sizeof(int));
 *
 *     for (int i = 0; i < 5; i++) {
 *         *(a + i) = i + 1;
 *     }
 *
 *     return a;
 * }
 *
 */

// #define LOCAL_TEST

enum {
    QUERY_1 = 1,
    QUERY_2 = 2,
};

typedef struct _dynamicArray {
    int *data;
    int dataCount;
} T_DynamicArray;

static FILE *s_fp = NULL;

int* dynamicArray(int n, int queries_rows, int queries_columns, int** queries, int* result_count) {
    int i, x, y;
    int lastAnswer = 0;
    int queryType = 0;
    int seqNum = 0, seqIndex = 0;
    int *result = (int *) malloc(sizeof(int));
    T_DynamicArray *sequenceData = (T_DynamicArray *) malloc(sizeof(struct _dynamicArray) * n);

    *result_count = 0;
    memset(sequenceData, 0, sizeof(struct _dynamicArray) * n);
    for (i = 0; i < queries_rows; i++) {
        queryType = queries[i][0];
        x = queries[i][1];
        y = queries[i][2];

        if (queryType == QUERY_1) {
            seqNum = (x ^ lastAnswer) % n;
            if (sequenceData[seqNum].dataCount == 0) {
                sequenceData[seqNum].data = (int *) malloc(sizeof(int));
                sequenceData[seqNum].dataCount++;
            } else {
                sequenceData[seqNum].dataCount++;
                sequenceData[seqNum].data = (int *) realloc(sequenceData[seqNum].data, sequenceData[seqNum].dataCount * sizeof(int));
            }
            sequenceData[seqNum].data[sequenceData[seqNum].dataCount - 1] = y;
        } else { /* QUERY_2 */
            seqNum = (x ^ lastAnswer) % n;
            seqIndex = y % sequenceData[seqNum].dataCount;
            lastAnswer = sequenceData[seqNum].data[seqIndex];
            *result_count += 1;
            result = (int *) realloc(result, *result_count * sizeof(int));
            *(result + *result_count - 1) = lastAnswer;
        }
    }

    for (i = 0; i < n; i++) {
        free(sequenceData[i].data);
    }
    free(sequenceData);

    return result;
}

int main()
{
#if !defined(LOCAL_TEST)
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");
#else
    s_fp = fopen("input.txt", "r");
#endif /* !LOCAL_TEST */

    char** nq = split_string(rtrim(readline()));

    char* n_endptr;
    char* n_str = nq[0];
    int n = strtol(n_str, &n_endptr, 10);

    if (n_endptr == n_str || *n_endptr != '\0') { exit(EXIT_FAILURE); }

    char* q_endptr;
    char* q_str = nq[1];
    int q = strtol(q_str, &q_endptr, 10);

    if (q_endptr == q_str || *q_endptr != '\0') { exit(EXIT_FAILURE); }

    int** queries = malloc(q * sizeof(int*));

    for (int i = 0; i < q; i++) {
        *(queries + i) = malloc(3 * (sizeof(int)));

        char** queries_item_temp = split_string(rtrim(readline()));

        for (int j = 0; j < 3; j++) {
            char* queries_item_endptr;
            char* queries_item_str = *(queries_item_temp + j);
            int queries_item = strtol(queries_item_str, &queries_item_endptr, 10);

            if (queries_item_endptr == queries_item_str || *queries_item_endptr != '\0') { exit(EXIT_FAILURE); }

            *(*(queries + i) + j) = queries_item;
        }
    }

    int queries_rows = q;
    int queries_columns = 3;

    int result_count;
    int* result = dynamicArray(n, queries_rows, queries_columns, queries, &result_count);

#if defined(LOCAL_TEST)
    for (int i = 0; i < result_count; i++) {
        printf("%d", *(result + i));

        if (i != result_count - 1) {
            printf("\n");
        }
    }

    printf("\n");
    fclose(s_fp);
#else  /* LOCAL_TEST */
    for (int i = 0; i < result_count; i++) {
        fprintf(fptr, "%d", *(result + i));

        if (i != result_count - 1) {
            fprintf(fptr, "\n");
        }
    }

    fprintf(fptr, "\n");

    fclose(fptr);
#endif /* !LOCAL_TEST */

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

        if (!line) {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n') {
            break;
        }

        alloc_length <<= 1;

        data = realloc(data, alloc_length);

        if (!data) {
            data = '\0';

            break;
        }
    }

    if (data[data_length - 1] == '\n') {
        data[data_length - 1] = '\0';

        data = realloc(data, data_length);

        if (!data) {
            data = '\0';
        }
    } else {
        data = realloc(data, data_length + 1);

        if (!data) {
            data = '\0';
        } else {
            data[data_length] = '\0';
        }
    }

    return data;
}

char* ltrim(char* str) {
    if (!str) {
        return '\0';
    }

    if (!*str) {
        return str;
    }

    while (*str != '\0' && isspace(*str)) {
        str++;
    }

    return str;
}

char* rtrim(char* str) {
    if (!str) {
        return '\0';
    }

    if (!*str) {
        return str;
    }

    char* end = str + strlen(str) - 1;

    while (end >= str && isspace(*end)) {
        end--;
    }

    *(end + 1) = '\0';

    return str;
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
