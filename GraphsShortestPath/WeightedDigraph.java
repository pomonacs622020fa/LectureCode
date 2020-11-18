import java.util.ArrayList;

/**
 * WeightedDigraph
 */
public class WeightedDigraph {

    private int numEdges;
    private int numVertices;

    private ArrayList<WeightedEdge>[] adjList;

    WeightedDigraph(int numVertices) {
        this.numEdges = 0;
        this.numVertices = numVertices;

        adjList = (ArrayList<WeightedEdge>[]) new ArrayList[numVertices];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public int getNumEdges() {
        return numEdges;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void addEdge(int from, int to, double weight) {
        // Error handling
        adjList[from].add(new WeightedEdge(from, to, weight));
    }

    public ArrayList<WeightedEdge> adjacentTo(int minVertex) {
        // Error handling
        return adjList[minVertex];
    }

    @Override
    public String toString() {
        StringBuilder graphString = new StringBuilder();
        graphString.append("numVertices: " + numVertices + "\n");
        graphString.append("numEdges   : " + numEdges + "\n");
        for (int i = 0; i < adjList.length; i++) {
            graphString.append("  " + i + " : ");
            String sep = "";
            for (WeightedEdge edge : adjList[i]) {
                graphString.append(sep + edge);
                sep = "; ";
            }
            graphString.append("\n");
        }
        return graphString.toString();
    }

    public static void main(String[] args) {
        WeightedDigraph graph = new WeightedDigraph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(0, 3, 2);

        graph.addEdge(0, 1, 47);
        graph.addEdge(3, 2, 0.05);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(3, 1, 1.47);

        System.out.println(graph);

        Dijkstras.computeShortestPath(graph, 3);
        // What is the length of the shortest path to each vertex
    }

}
