import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    
    static int getAnHourglassSum(int[][] arr, int startRow, int startCol) {
        int sum = 0;
        for(int i = startRow; i < startRow + 3; i++) {
            for(int j = startCol; j < startCol + 3; j++) {
                if(i == startRow + 1 && (j == startCol || j == startCol + 2)) {
                    continue;
                }
                sum += arr[i][j];
            }
        }
        
        return sum;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length - 2; i++) {
            for(int j = 0; j < arr[i].length - 2; j++) {
                int sum = getAnHourglassSum(arr, i, j);
                if(sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
