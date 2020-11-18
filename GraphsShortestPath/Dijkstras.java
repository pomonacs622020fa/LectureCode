import java.util.ArrayList;

public class Dijkstras {

    public static void computeShortestPath(WeightedDigraph graph, int startVertex) {
        IndexMinPQ<Double> vertexMinHeap = new IndexMinPQ<>(graph.getNumVertices());

        int[] predecessors = new int[graph.getNumVertices()];
        double[] distanceTo = new double[graph.getNumVertices()];

        for (int i = 0; i < distanceTo.length; i++) {
            distanceTo[i] = Double.POSITIVE_INFINITY;
        }

        distanceTo[startVertex] = 0;
        predecessors[startVertex] = startVertex;

        vertexMinHeap.insert(startVertex, 0.0);

        while (!vertexMinHeap.isEmpty()) {
            int fromVertex = vertexMinHeap.delMin();

            for (WeightedEdge edge : graph.adjacentTo(fromVertex)) {

                int toVertex = edge.getToVertex();

                double testDistance = distanceTo[fromVertex] + edge.getWeight();

                if (testDistance < distanceTo[toVertex]) {
                    distanceTo[toVertex] = testDistance;
                    predecessors[toVertex] = fromVertex;

                    if (vertexMinHeap.contains(toVertex)) {
                        vertexMinHeap.decreaseKey(toVertex, testDistance);
                    } else {
                        vertexMinHeap.insert(toVertex, testDistance);
                    }
                }

            }
        }

        // Print the distances
        for (int i = 0; i < distanceTo.length; i++) {
            System.out.println("Distance from " + startVertex + " to " + i + " is " + distanceTo[i]);
            ArrayList<Integer> path = new ArrayList<>();

            int currentVertex = i;
            path.add(currentVertex);
            if (!Double.isInfinite(distanceTo[i])) {
                while (currentVertex != startVertex) {
                    currentVertex = predecessors[currentVertex];
                    path.add(currentVertex);
                }
                System.out.print("  ");
            }

            String sep = "";
            for (int j = path.size() - 1; j >= 0; j--) {
                System.out.print(sep + path.get(j));
                sep = " --> ";
            }
            System.out.println();
        }
    }
}
