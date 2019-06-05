import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static final String BLANK_REGEX = "(\r\n|[\n\r\u2028\u2029\u0085])?";

    private static final Scanner scanner = new Scanner(System.in);
    private static boolean LOG_MODE = false;

    private static Stack<Integer> eqStack = new Stack<Integer>();
    private static Stack<Integer> dqStack = new Stack<Integer>();

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int query = scanner.nextInt();
        scanner.skip(BLANK_REGEX);

        for (int testsItr = 0; testsItr < query; testsItr++) {
            int method = scanner.nextInt();
            scanner.skip(BLANK_REGEX);
            
            switch (method) {
                case 1: 
                    int value = scanner.nextInt();
                    scanner.skip(BLANK_REGEX);
                    enQueue(value);
                break;

                case 2:
                    deQueue();
                break;

                case 3:
                    poll();
                break;
            }
        }
        scanner.close();
    }

    private static void enQueue(int value) {
        if (LOG_MODE) {
            System.out.println("enQueue, value: " + value);                
        }
        eqStack.push(value);
    }

    private static void deQueue() {
        if (dqStack.isEmpty()) {
            while (!eqStack.isEmpty()) {
                dqStack.push(eqStack.pop());
            }
        }

        if (LOG_MODE) {
            System.out.println("deQueue");
        }
        dqStack.pop();
    }

    private static void poll() {
        if (LOG_MODE) {
            System.out.println("poll");     
        }
        
        if (dqStack.isEmpty()) {
            while (!eqStack.isEmpty()) {
                dqStack.push(eqStack.pop());
            }
        }
        
        System.out.println(dqStack.peek());     
    }
}

