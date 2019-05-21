
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author baejunbeom
 */
public class DynamicArray {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int q = scanner.nextInt();

		List<Integer>[] seq = new List[n];

		for (int i = 0; i < seq.length; i++) {
			seq[i] = new LinkedList<Integer>();
		}

		int lastAnswer = 0;

		for (int i = 0; i < q; i++) {
			int query = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();

			if (query == 1) {
				seq[(x^lastAnswer) % n].add(y);
			} else {
				List<Integer> list = seq[(x ^ lastAnswer) % n];
				lastAnswer = list.get(y % list.size());
				System.out.println(lastAnswer);
			}
		}
	}
}
