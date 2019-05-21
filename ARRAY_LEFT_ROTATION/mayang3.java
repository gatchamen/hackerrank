import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author neo82
 */
public class LeftRotation {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int d = scanner.nextInt();

		LinkedList<Integer> arr = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			arr.add(scanner.nextInt());
		}

		for (int i = 0; i < d; i++) {
			arr.addLast(arr.removeFirst());
		}

		for (int v : arr) {
			System.out.print(v + " ");
		}
	}
}
