/**
 * Imports Scanner class.
 * @author: Prasamsa
 * Date: 11th November, 2018
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
        // Self loops are not allowed...
        // Parallel Edges are allowed...
        // Take the Graph input here...
        Scanner s = new Scanner(System.in);
        int vertices = Integer.parseInt(s.nextLine());
        int edges = Integer.parseInt(s.nextLine());
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(vertices);
        for (int i = 0; i < edges; i++) {
            String[] tokens = s.nextLine().split(" ");
            Edge edge = new Edge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            ewg.addEdge(edge);
        }

        String caseToGo = s.nextLine();
        switch (caseToGo) {
        case "Graph":
            //Print the Graph Object.
            System.out.println(vertices + " vertices " + edges + " edges");
            System.out.println(ewg);
            break;

        case "DirectedPaths":
            // Handle the case of DirectedPaths, where two integers are given.
            String[] tokens = s.nextLine().split(" ");
            // First is the source and second is the destination.
            DijkstraUndirectedSP ds = new DijkstraUndirectedSP(ewg,
                Integer.parseInt(tokens[0]));
            // If the path exists print the distance between them.
            if (ds.hasPathTo(Integer.parseInt(tokens[1]))) {
                System.out.format("%.01f", ds.distTo(
                    Integer.parseInt(tokens[1])));
            // Other wise print "No Path Found."
            } else {
                System.out.println("No Path Found.");
            }
            break;

        case "ViaPaths":
            // Handle the case of ViaPaths, where three integers are given.
            String[] tokens1 = s.nextLine().split(" ");
            // First is the source and second is the via is the
            // one where path should pass throuh.
            // third is the destination.
            // If the path exists print the distance between them.
            // Other wise print "No Path Found."
            System.out.println("No Path Found.");
            break;

        default:
            break;
        }

    }
}
