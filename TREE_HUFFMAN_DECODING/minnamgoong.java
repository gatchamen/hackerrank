import java.util.*;
 
abstract class Node implements Comparable<Node> {
    
  	public  int frequency; // the frequency of this tree
    public  char data;
    public  Node left, right; 
    public Node(int freq) { 
    	frequency = freq;
   	}
 
    // compares on the frequency
    public int compareTo(Node tree) {
        return frequency - tree.frequency;
    }
  
}
 
class HuffmanLeaf extends Node {
    
    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
  
}
 
class HuffmanNode extends Node {
    
    public HuffmanNode(Node l, Node r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

}


class Decoding {

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

    void decode(String s, Node root) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            System.out.printf("[%d]", i);
            if (c == '0') {                
                if (cur.left != null && cur.left.data == 0) {
                    cur = cur.left;    
                } else {       
                    System.out.print(cur.left.data);
                    cur = root;                                               
                }
            } else if (c == '1') {
                if (cur.right != null && cur.right.data == 0) {
                    cur = cur.right;
                } else {
                    System.out.print(cur.right.data);
                    cur = root;
                }
            }
        }
    }

