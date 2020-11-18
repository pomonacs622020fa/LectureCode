import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * AdjacencyList
 */
public class AdjacencyList implements Graph {
    private ArrayList<HashSet<Integer>> graph;
    private int n, m;

    // Used for debug visualization and searching
    private HashSet<Integer> visited;
    private int visiting;

    AdjacencyList(int numVertices) {
        graph = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            graph.add(new HashSet<>());
        }
        n = numVertices;
        m = 0;

        visited = new HashSet<>();
        visiting = -1;
    }

    @Override
    public int getNumVertices() {
        return n;
    }

    @Override
    public int getNumEdges() {
        return m;
    }

    @Override
    public void addEdge(int v1, int v2) {
        int n = graph.size();
        if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
            throw new IllegalArgumentException("Vertex not in graph.");
        }

        // Ignore the new edge if it already exists
        if (!graph.get(v1).contains(v2)) {
            graph.get(v1).add(v2);
            m += 1;
        }
    }

    @Override
    public String toJson() {
        StringBuilder json = new StringBuilder();
        // Header
        json.append("{\"kind\": { \"graph\": true },\"nodes\": [");

        // Vertices
        String sep = "";
        // color
        for (int v = 0; v < graph.size(); v++) {
            String color = visited.contains(v) ? "lightgreen" : "lightblue";
            color = visiting == v ? "yellow" : color;
            json.append(sep + "{\"id\":\"" + v + "\",\"label\":\"" + v + "\",\"color\":\"" + color + "\"}");
            sep = ",";
        }

        // Edges
        json.append("],\"edges\": [");
        sep = "";
        // color
        for (int vf = 0; vf < graph.size(); vf++) {
            for (int vt : graph.get(vf)) {
                json.append(sep + "{\"from\":\"" + vf + "\",\"to\":\"" + vt + "\",\"color\":\"black\"}");
                sep = ",";
            }
        }
        json.append("]}");
        return json.toString();
    }

    @Override
    public void BFS(int startVertex) {
        visited = new HashSet<>();
        visited.add(startVertex);
        visiting = startVertex;

        ArrayDeque<Integer> visitQueue = new ArrayDeque<>();
        visitQueue.add(startVertex);

        while (visitQueue.size() > 0) {
            int currentVertex = visitQueue.removeFirst();
            for (Integer v : graph.get(currentVertex)) {
                visiting = currentVertex;
                if (!visited.contains(v)) {
                    visited.add(v);
                    visitQueue.add(v);
                }
            }
        }
    }

    @Override
    public void DFS(int startVertex) {
        visited = new HashSet<>();
        visiting = startVertex;
        DFSHelper(startVertex);
    }

    public void DFSHelper(int currentVertex) {
        visited.add(currentVertex);
        for (Integer v : graph.get(currentVertex)) {
            visiting = currentVertex;
            if (!visited.contains(v)) {
                DFSHelper(v);
            }
        }
        visiting = currentVertex;
    }

    public static void main(String[] args) {
        Graph g = new AdjacencyList(5);

        g.addEdge(0, 1);
        g.addEdge(0, 3);

        g.addEdge(1, 3);

        g.addEdge(2, 3);

        g.addEdge(3, 4);

        // g.BFS(0);
        g.DFS(0);

        int numVertices = 5;
        g = new AdjacencyList(numVertices);

        Random rgen = new Random();
        while (g.getNumEdges() < numVertices * 1.2) {
            int vFrom = rgen.nextInt(g.getNumVertices());
            int vTo = rgen.nextInt(g.getNumVertices());
            if (vFrom == vTo)
                continue;
            g.addEdge(vFrom, vTo);
        }

        g.BFS(rgen.nextInt(g.getNumVertices()));
        g.DFS(rgen.nextInt(g.getNumVertices()));
    }

}
