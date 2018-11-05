/**
 * Imports Scanner class.
 */
import java.util.Scanner;
/**
 * Class for solution.
 */
public final class Solution {
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
        int vertices = Integer.parseInt(s.nextLine());
        int edges = Integer.parseInt(s.nextLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(vertices);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            ewg.addEdge(edge);
        }
        KruskalMST krus = new KruskalMST(ewg);
        System.out.format("%.5f", krus.weight());
    }
}
