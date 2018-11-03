import java.util.Scanner;
class PageRank {
	float[] pr;

	PageRank(Digraph graph) {
		Scanner s = new Scanner(System.in);
		s.nextLine();
		String[] tokens = s.nextLine().split(" ");
		int data = Integer.parseInt(tokens[0]);
		int indegree = graph.indegree(data);
		int den = graph.V();
		for (int i = 0; i < den; i++) {
			pr[i] = 1 / den;
		}
	}
}

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices
		Scanner s = new Scanner(System.in);
		int vertices = Integer.parseInt(s.nextLine());
		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		Digraph graph = new Digraph(vertices);
		for (int i = 0; i < vertices; i++) {
			String[] tokens = s.nextLine().split(" ");
			int data = Integer.parseInt(tokens[0]);
			for (int j = 1; j < tokens.length; j++) {
				String[] tokens1 = s.nextLine().split(" ");
				graph.addEdge(data, Integer.parseInt(tokens1[j]));
			}
		}
		
		
		// Create page rank object and pass the graph object to the constructor
		PageRank pr = new PageRank(graph);
		
		// print the page rank object
		System.out.println(pr);
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
