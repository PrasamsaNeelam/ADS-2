/**
 * Imports Scanner class.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * Main function to drive the program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		int v = s.nextInt();
		int e = s.nextInt();
		Digraph dg = new Digraph(v);
		s.nextLine();
		while (s.hasNext()) {
			String lines = s.nextLine();
			String[] tokens = lines.split(" ");
			dg.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
		}
		DirectedCycle dc = new DirectedCycle(dg);
		if (dc.hasCycle()) {
			System.out.println("Cycle exists.");
		} else {
			System.out.println("Cycle doesn't exists.");
		}
	}
}
