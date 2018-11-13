import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		TST<Integer> tst = new TST<Integer>();
		String[] words = loadWords();
		Scanner s = new Scanner(System.in);
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				String str = words[i].substring(j);
				if (!tst.contains(str)) {
					tst.put(str, i);
				}
			}
		}
		String prefix = s.nextLine();
		for(String everykey : tst.keysWithPrefix(prefix)) {
			System.out.println(everykey);
		}

	}

	public static String[] loadWords() {
		In in = new In("/Files/dictionary-algs4.txt");
		String[] words = in.readAllStrings();
		return words;
	}
}
