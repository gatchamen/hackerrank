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
#define SUM_COORDINATE_NUM  7
#define INIT_MINIMUN_SUM    -64

typedef struct t_sumCoordinate{
    int x;
    int y;
} T_SumCoordinate;

static FILE *s_fp = NULL;

// Complete the hourglassSum function below.
int hourglassSum(int arr_rows, int arr_columns, int** arr) {
    T_SumCoordinate sumCoordinates[SUM_COORDINATE_NUM] = {
        {-1, -1}, {-1,  0}, {-1,  1}, { 0,  0},
        { 1, -1}, { 1,  0}, { 1,  1}
    };
    int i, j, k;
    int hourglassSum = 0, maxHourglassSum = INIT_MINIMUN_SUM;

    for (i = 1; i < arr_rows - 1; i++) {
        for (j = 1; j < arr_columns - 1; j++) {
            hourglassSum = 0;
            for (k = 0; k < SUM_COORDINATE_NUM; k++) {
                hourglassSum += arr[i + sumCoordinates[k].x][j + sumCoordinates[k].y];
            }

            if (maxHourglassSum < hourglassSum) {
                maxHourglassSum = hourglassSum;
            }
        }
    }
    return maxHourglassSum;
}

int main()
{
#if !defined(LOCAL_TEST)
    FILE* fptr = fopen(getenv("OUTPUT_PATH"), "w");
#else
    s_fp = fopen("input.txt", "r");
#endif /* !LOCAL_TEST */

    int** arr = malloc(6 * sizeof(int*));

    for (int i = 0; i < 6; i++) {
        *(arr + i) = malloc(6 * (sizeof(int)));

        char** arr_item_temp = split_string(readline());

        for (int j = 0; j < 6; j++) {
            char* arr_item_endptr;
            char* arr_item_str = *(arr_item_temp + j);
            int arr_item = strtol(arr_item_str, &arr_item_endptr, 10);

            if (arr_item_endptr == arr_item_str || *arr_item_endptr != '\0') { exit(EXIT_FAILURE); }

            *(*(arr + i) + j) = arr_item;
        }
    }

    int arr_rows = 6;
    int arr_columns = 6;

    int result = hourglassSum(arr_rows, arr_columns, arr);

#if defined(LOCAL_TEST)
    printf("%d\n", result);

    fclose(s_fp);
#else  /* LOCAL_TEST */
    fprintf(fptr, "%d\n", result);

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
