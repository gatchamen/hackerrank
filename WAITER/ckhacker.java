import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
         */
        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> tmp = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int primeNumber = 2;
        
        for(int i = 0; i < number.length; i++) {
            a.push(number[i]);
        }
        
        for(int i = 0; i < q; i++, primeNumber++) {
            for( ; primeNumber <= 10000; primeNumber++) {
                boolean isPrime = true;
                for(int j = 2; j < primeNumber; j++) {
                    if(primeNumber % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                
                if(isPrime) {
                    break;
                }
            }
            
            
            while(!a.empty()) {
                int n = a.pop();
                if(n % primeNumber == 0) {
                    b.push(n);
                }
                else {
                    tmp.push(n);
                }
            }
            
            Stack<Integer> t = a;
            a = tmp;
            tmp = t;
            
            while(!b.empty()) {
                result.add(b.pop());
            }
        }
        
        while(!a.empty()) {
            result.add(a.pop());
        }
        
        int[] resultArray = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
