/**
 * Scanner import.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String[] tokens = s.nextLine().split(" ");
        int vertex = Integer.parseInt(tokens[0]);
        int edges = Integer.parseInt(tokens[1]);
        BinarySearchST<String, Integer> bst
        = new BinarySearchST<String, Integer>();
        String[] vertices = s.nextLine().split(" ");
        for (int i = 0; i < vertices.length; i++) {
            bst.put(vertices[i], i);
        }
        Edge e;
        EdgeWeightedGraph ewg =
        new EdgeWeightedGraph(vertex);
        for (int i = 0; i < edges; i++) {
            String[] data = s.nextLine().split(" ");
            e = new Edge(bst.get(tokens[0]),
                bst.get(data[1]), Double.parseDouble(data[2]));
            ewg.addEdge(e);
        }
        int queries = Integer.parseInt(s.nextLine());
        DijkstrasSP djk;
        for (int i = 0; i < queries; i++) {
            String[] paths = s.nextLine().split(" ");
            int source = bst.get(paths[0]);
            djk = new DijkstrasSP(ewg, source);
            System.out.println((int) djk.distance(bst.get(paths[1])));
        }
    }
}