

/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

    void decode(String s, Node root) {
        Node node = root;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                node = node.left;
            }
            else {
                node = node.right;
            }

            if(node.left == null && node.right == null) {
                System.out.print(node.data);
                node = root;
            }
        }
    }

