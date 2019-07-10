
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(System.in); 
			
        int T = in.nextInt();
        
        for(int i = 0; i < T; i++) {
        	int K = in.nextInt();
        	in.nextLine();
        	String tree = in.nextLine();
        	int sum = 0;
        	
        	int level = -1;
        	StringBuilder sb = new StringBuilder();
        	for(int j = 0; j < tree.length(); j++) {
        		switch(tree.charAt(j)) {
    			case '(':
    				if(level == K) {
    					if(sb.length() > 0) {
    						sum += Integer.parseInt(sb.toString());
    					}
    				}
    				sb.setLength(0);
    				level++;
    				break;
    			case ')':
    				level--;
    				break;
    			default:
    				if(tree.charAt(j) >= '0' && tree.charAt(j) <= '9') {
    					sb.append(tree.charAt(j));
    				}
    				break;
    			}
        	}
        	
        	System.out.println(sum);
        }
        
        in.close();
	}
}
