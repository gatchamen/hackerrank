
/**
 * @author neo82
 */
public class IsThisABinarySearchTree {

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	boolean checkBST(Node root) {
		return solve(root, 0, (int)1e4);
	}

	boolean solve(Node root, int min, int max) {
		if (root == null) {
			return true;
		} else if (root.data <= min || root.data >= max) {
			return false;
		}

		return solve(root.left, min, root.data) && solve(root.right, root.data, max);
	}

}
