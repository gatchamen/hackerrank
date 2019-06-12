import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {
        int[] containerSize = new int[container.length];
        int[] typeCount = new int[container.length];
        Arrays.fill(containerSize, 0);
        Arrays.fill(typeCount, 0);
        
        for(int i = 0; i < container.length; i++) {
            int count = 0;
            for(int j = 0; j < container.length; j++) {
                count += container[i][j];
                typeCount[j] += container[i][j];
            }
            containerSize[i] = count;
        }
        
        for(int i = 0; i < typeCount.length; i++) {
            for(int j = 0; j < containerSize.length; j++) {
                if(typeCount[i] == containerSize[j]) {
                    containerSize[j] = 0;
                }
            }
        }
        
        for(int i = 0; i < containerSize.length; i++) {
            if(containerSize[i] != 0) {
                return "Impossible";
            }
        }
        
        return "Possible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] container = new int[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
