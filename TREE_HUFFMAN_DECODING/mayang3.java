/**
 * @author neo82
 */
public class HuffmanDecoding {

	static class Node {
		int freuqency;
		Character data;
		Node left, right;

		public Node(int freuqency, Character data, Node left, Node right) {
			this.freuqency = freuqency;
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	void decode(String s, Node root) {

		int i = 0;

		StringBuilder sb = new StringBuilder();

		while (i < s.length()) {

			Node next = root;

			while (true) {
				char ch = s.charAt(i);

				if (ch == '0') {
					next = next.left;
				} else {
					next = next.right;
				}

				i++;

				if (next.left == null && next.right == null) {
					sb.append(next.data);
					break;
				}

			}
		}

		System.out.println(sb.toString());
	}

}
