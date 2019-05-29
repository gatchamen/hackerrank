/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
    static Integer lastChecked = null;

    static boolean checkBST(Node root) {
        if (root == null) {
            return true; // null이면 BST인가? 흐음;;
        }
        
        if (!checkBST(root.left)) {
            return false;
        }
        
        // 현재 노드 검사
        if (lastChecked != null && root.data <= lastChecked) {
            return false;
        } 
        lastChecked = root.data;
        
        if (!checkBST(root.right)) {
            return false;   
        }
        
        return true;
        
    }
