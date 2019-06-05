import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static public class Point {
        public int x;
        public int y;
        
        public Point() {
            x = -1;
            y = -1;
        }
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int[][] visit = new int[grid.length][grid.length];
        for(int i = 0; i < visit.length; i++) {
            for(int j = 0; j < visit.length; j++) {
                visit[i][j] = -1;
            }
        }
        
        Queue<Point> queue = new LinkedList<>();
        visit[startX][startY] = 0;
        
        int x = startX;
        int y = startY;
        
        while(true) {
            if(x > 0) {
                for(int i = x - 1; i >=0; i--) {
                    if(grid[i].charAt(y) == '.') {
                        if(visit[i][y] < 0) {
                            visit[i][y] = visit[x][y] + 1;
                            queue.add(new Point(i, y));
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            
            if(x < grid.length - 1) {
                for(int i = x + 1; i < grid.length; i++) {
                    if(grid[i].charAt(y) == '.') {
                        if(visit[i][y] < 0) {
                            visit[i][y] = visit[x][y] + 1;
                            queue.add(new Point(i, y));
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            
            if(y > 0) {
                for(int i = y - 1; i >= 0; i--) {
                    if(grid[x].charAt(i) == '.') {
                        if(visit[x][i] < 0) {
                            visit[x][i] = visit[x][y] + 1;
                            queue.add(new Point(x, i));
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            
            if(y < grid.length - 1) {
                for(int i = y + 1; i < grid.length; i++) {
                    if(grid[x].charAt(i) == '.') {
                        if(visit[x][i] < 0) {
                            visit[x][i] = visit[x][y] + 1;
                            queue.add(new Point(x, i));
                        }
                    }
                    else {
                        break;
                    }
                }
            }
            if(queue.isEmpty()) {
                break;
            }
            else {
                Point point = queue.poll();
                x = point.x;
                y = point.y;
                
                if(x == goalX && y == goalY) {
                    break;
                }
            }
        }
        
        return visit[x][y];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            String gridItem = scanner.nextLine();
            grid[i] = gridItem;
        }

        String[] startXStartY = scanner.nextLine().split(" ");

        int startX = Integer.parseInt(startXStartY[0]);

        int startY = Integer.parseInt(startXStartY[1]);

        int goalX = Integer.parseInt(startXStartY[2]);

        int goalY = Integer.parseInt(startXStartY[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
