import java.util.Arrays;
import java.util.Scanner;

public class GFG {
	public static void main (String[] args) throws IOException {
		Scanner in = new Scanner(System.in); 
			
        int T = in.nextInt();
        
        for(int i = 0; i < T; i++) {
        	N = in.nextInt();
        	in.nextLine();
        	arr = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        	count = 0;
        	
        	root = new Node(arr[count++]);
        	makeTree(root, 0, Integer.MAX_VALUE);
        	postorder(root);
        	System.out.println();
        }
        
        in.close();
	}
	
	static int count;
	static int[] arr;
	static int N;
	static Node root;
	
	static void makeTree(Node node, int min, int max) {
		if(count < N && min < arr[count] && arr[count] < max && node.key > arr[count]) {
			Node newNode = new Node(arr[count++]);
			node.left = newNode;
			makeTree(newNode, min, node.key);
		}
			
		if(count < N && min < arr[count] && arr[count] < max && node.key < arr[count]) {
			Node newNode = new Node(arr[count++]);
			node.right = newNode;
			makeTree(newNode, node.key, max);
		}	
	}
		
	static void postorder(Node node) {
		if(node == null) {
			return;
		}
		
		postorder(node.left);
		postorder(node.right);
		System.out.print(node.key + " ");
	}
	
	static class Node {
		public int key;
		public Node left;
		public Node right;
		
		public Node(int key) {
			this.key = key;
			left = null;
			right = null;
		}
	}
}
