
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static class Queue {
        Stack<Integer> inStack = new Stack<>();
        Stack<Integer> outStack = new Stack<>();

        public void enqueue(int n) {
            inStack.push(n);
        }

        private void move() {
            if(outStack.empty()) {
                while(!inStack.empty()) {
                    int pop = inStack.pop();
                    outStack.push(pop);
                }
            }
        }

        public void dequeue() {
            move();
            outStack.pop();
        }

        public int peek() {
            move();
            return outStack.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Queue queue = new Queue();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));

        for(int i = 0; i < n; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            switch(queriesRowTempItems[0]) {
                case "1":
                    int number = Integer.parseInt(queriesRowTempItems[1]);
                    queue.enqueue(number);
                    break;
                case "2":
                    queue.dequeue();
                    break;
                case "3":
                    System.out.println(queue.peek());
                    break;
            }
        }

        bufferedReader.close();
    }
}

