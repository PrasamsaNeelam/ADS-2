import java.util.Scanner;
import java.io.File;
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {
		//unused constructor.
	}
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		String synset = StdIn.readString();
		String hypernym = StdIn.readString();
		String type = StdIn.readString();
		try {
			if (type.equals("Graph")) {
				WordNet wordnet = new WordNet(synset, hypernym);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if(type.equals("Queries")) {
			String[] query = StdIn.readString().split(" ");
			if(query[0].equals("null")) {
				System.out.println("IllegalArgumentException");
			}
		}

	}
}