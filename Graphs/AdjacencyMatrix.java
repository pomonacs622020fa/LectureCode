import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class AdjacencyMatrix implements Graph {
    private ArrayList<ArrayList<Integer>> graph;
    private int n, m;

    // Used for debug visualization and searching
    private HashSet<Integer> visited;
    private int visiting;

    AdjacencyMatrix(int numVertices) {
        graph = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>(numVertices));
            for (int j = 0; j < numVertices; j++) {
                graph.get(i).add(0);
            }
        }
        n = numVertices;

        visited = new HashSet<>();
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
        if (v1 < 0 || v1 >= n || v2 < 0 || v2 >= n) {
            throw new IllegalArgumentException("Vertex not in graph.");
        }
        if (graph.get(v1).get(v2).equals(0)) {
            graph.get(v1).add(v2, 1);
            m += 1;
        }
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
            visiting = currentVertex;
            for (int vt = 0; vt < n; vt++) {
                if (graph.get(currentVertex).get(vt).equals(1)) {
                    if (!visited.contains(vt)) {
                        visited.add(vt);
                        visitQueue.add(vt);
                    }
                }
            }
        }
    }

    @Override
    public void DFS(int startVertex) {
        // TODO Auto-generated method stub

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
        for (int vf = 0; vf < n; vf++) {
            for (int vt = 0; vt < n; vt++) {
                if (graph.get(vf).get(vt).equals(1)) {
                    json.append(sep + "{\"from\":\"" + vf + "\",\"to\":\"" + vt + "\",\"color\":\"black\"}");
                    sep = ",";
                }
            }
        }
        json.append("]}");
        return json.toString();
    }

    public static void main(String[] args) {
        Graph g = new AdjacencyMatrix(5);

        g.addEdge(0, 1);
        g.addEdge(0, 3);

        g.addEdge(1, 3);

        g.addEdge(2, 3);

        g.addEdge(3, 4);

        g.BFS(0);
        g.DFS(0);

        g.toJson();

        int numVertices = 8;
        g = new AdjacencyList(numVertices);

        Random rgen = new Random();
        while (g.getNumEdges() < numVertices * 2.5) {
            int vFrom = rgen.nextInt(g.getNumVertices());
            int vTo = rgen.nextInt(g.getNumVertices());
            g.addEdge(vFrom, vTo);
        }

        g.BFS(rgen.nextInt(g.getNumVertices()));
        g.DFS(rgen.nextInt(g.getNumVertices()));
    }
}
