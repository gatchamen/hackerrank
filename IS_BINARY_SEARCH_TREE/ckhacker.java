/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

boolean checkBST(Node node, int min, int max) {
    boolean result = true;
    if(node.left != null) {
        if(node.data > node.left.data && node.left.data > min && node.left.data < max) {
            result = checkBST(node.left, min, node.data);
        }
        else {
            return false;
        }
    }
    if(result && node.right != null) {
        if(node.data < node.right.data && node.right.data > min && node.right.data < max) {
            result = checkBST(node.right, node.data, max);
        }
        else {
            return false;
        }
    }
    
    return result;
}
    
boolean checkBST(Node root) {
    return checkBST(root, -1, 10001);
}
