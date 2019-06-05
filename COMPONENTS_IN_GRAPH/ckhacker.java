import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static Map<Integer,List<Integer>> v = new HashMap<>();
    static Map<Integer,Boolean> visit = new HashMap<>();
    
    /*
     * Complete the componentsInGraph function below.
     */
    static int[] componentsInGraph(int[][] gb) {
        /*
         * Write your code here.
         */
        int[] result = new int[2];
        for(int i = 0; i < gb.length; i++) {
            
            int v1 = gb[i][0];
            int v2 = gb[i][1];
            List<Integer> list1;
            List<Integer> list2;
            
            if(!v.containsKey(v1)) {
                list1 = new ArrayList<>();
                v.put(v1, list1);
            }
            else {
                list1 = v.get(v1);
            }
            
            if(!v.containsKey(v2)) {
                list2 = new ArrayList<>();
                v.put(v2, list2);
            }
            else {
                list2 = v.get(v2);
            }
            
            list1.add(v2);
            list2.add(v1);
        }
        
        for(int i : v.keySet()) {
            visit.put(i, false);
        }
        
        int min = 30001;
        int max = 0;
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i : v.keySet()) {
            if(!visit.get(i)) {
                int count = 1;
                visit.put(i, true);
                q.addAll(v.get(i));
                while(!q.isEmpty()) {
                    int n = q.poll();
                    if(!visit.get(n)) {
                        visit.put(n, true);
                        q.addAll(v.get(n));
                        count++;
                    }
                }
                
                if(min > count) {
                    min = count;
                }
                
                if(max < count) {
                    max = count;
                }
            }
        }

        result[0] = min;
        result[1] = max;
        return result;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] gb = new int[n][2];

        for (int gbRowItr = 0; gbRowItr < n; gbRowItr++) {
            String[] gbRowItems = scanner.nextLine().split(" ");

            for (int gbColumnItr = 0; gbColumnItr < 2; gbColumnItr++) {
                int gbItem = Integer.parseInt(gbRowItems[gbColumnItr].trim());
                gb[gbRowItr][gbColumnItr] = gbItem;
            }
        }

        int[] result = componentsInGraph(gb);
        System.out.println(result[0] + " " + result[1]);
    }
}
