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
            String[] paths = s.nextLine().split(" ");
            int source = Integer.parseInt(paths[0]);
            int via = Integer.parseInt(paths[1]);
            int destination = Integer.parseInt(paths[2]);
            String str = "";

            DijkstraUndirectedSP sp1 =
                new DijkstraUndirectedSP(ewg, source);
            if (sp1.hasPathTo(destination)) {
                // str1 = sp1.pathTo(d1).toString();
                Queue<Integer> queue = new Queue<Integer>();
                for (Edge edge : sp1.pathTo(via)) {
                    int vertex = edge.either();
                    int other = edge.other(vertex);
                    int count1 = 0;
                    int count2 = 0;
                    for (Integer i : queue) {
                        if (vertex == i) {
                            count1 = 1;
                        }
                        if (other == i) {
                            count2 = 1;
                        }
                    }
                    if (count2 == 0) {
                        queue.enqueue(other);
                    }
                    if (count1 == 0) {
                        queue.enqueue(vertex);
                    }
                }
                DijkstraUndirectedSP sp2 =
                    new DijkstraUndirectedSP(ewg, via);
                for (Edge edge : sp2.pathTo(destination)) {
                    int vertex = edge.either();
                    int other = edge.other(vertex);
                    int count1 = 0;
                    int count2 = 0;
                    for (Integer i : queue) {
                        if (vertex == i) {
                            count1 = 1;
                        }
                        if (other == i) {
                            count2 = 1;
                        }

                    }
                    if (count1 == 0) {
                        queue.enqueue(vertex);
                    }
                    if (count2 == 0) {
                        queue.enqueue(other);
                    }
                }
                System.out.println(sp1.distTo(via)
                                   + sp2.distTo(destination));
                while (!queue.isEmpty()) {
                    str += queue.dequeue() + " ";
                }
                System.out.print(str.trim());
            } else {
                System.out.println("No Path Found.");
            }
            // System.out.println(dist1 + dist2);
            break;

        default:
            break;
        }

    }
}
