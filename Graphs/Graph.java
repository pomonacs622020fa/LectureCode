public interface Graph {
    int getNumVertices();

    int getNumEdges();

    void addEdge(int v1, int v2);

    void BFS(int startVertex);

    void DFS(int startVertex);

    String toJson();
}
