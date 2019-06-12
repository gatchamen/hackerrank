import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(bufferedReader.readLine().replaceAll("\\s+$", ""));
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < Q; i++) {
            String[] cmd = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            if(cmd[0].equals("1")) {
                stack.push(sb.toString());
                sb.append(cmd[1]);
            }

            else if(cmd[0].equals("2")) {
                stack.push(sb.toString());
                int delCount = Integer.parseInt(cmd[1]);
                sb.delete(sb.length() - delCount, sb.length() + delCount);
            }

            else if(cmd[0].equals("3")) {
                System.out.println(sb.charAt(Integer.parseInt(cmd[1]) - 1));
            }

            else if(cmd[0].equals("4")) {
                sb = new StringBuilder(stack.pop());
            }
        }

        bufferedReader.close();
    }
}

