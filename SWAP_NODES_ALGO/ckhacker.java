import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static void inorder(int[][] indexes, int nodeIndex, int d, int k, List<Integer> result) {
        if(nodeIndex == -1) {
            return;
        }

        // swap
        if(d % k == 0) {
            int tmp = indexes[nodeIndex - 1][0];

            indexes[nodeIndex - 1][0] = indexes[nodeIndex - 1][1];
            indexes[nodeIndex - 1][1] = tmp;
        }

        inorder(indexes, indexes[nodeIndex - 1][0], d+1, k, result);
        result.add(nodeIndex);
        inorder(indexes, indexes[nodeIndex - 1][1], d+1, k, result);
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        /*
         * Write your code here.
         */
        int[][] result = new int[queries.length][indexes.length];
        
        for(int i = 0; i < queries.length; i++) {
            List<Integer> r = new ArrayList<>();
            inorder(indexes, 1, 1, queries[i], r);
            for(int j = 0; j < r.size(); j++) {
                result[i][j] = r.get(j);
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
