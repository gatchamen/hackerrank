import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void exec(int[] A, int start, int end) {
        if(end < start) {
            return;
        }


        int index = start + (end - start) / 2;

        System.out.print(A[index] + " ");
        exec(A, start, index - 1);
        exec(A, index + 1, end);
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        int T = in.nextInt();

        for(int i = 0; i < T; i++) {
            int N = in.nextInt();
            int[] A = new int[N];
            for(int j = 0; j < N; j++) {
                A[j] = in.nextInt();

            }
            exec(A, 0, N - 1);
            System.out.println();
        }

        in.close();
    }
}
