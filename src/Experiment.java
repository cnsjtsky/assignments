public class Experiment {

    public void runTraversals(Graph g) {

        long start;
        long end;

        System.out.println("\nBFS Traversal:");
        start = System.nanoTime();
        g.bfs(0);
        end = System.nanoTime();

        System.out.println("BFS Time: " + (end - start) + " ns");

        System.out.println("\nDFS Traversal:");
        start = System.nanoTime();
        g.dfs(0);
        end = System.nanoTime();

        System.out.println("DFS Time: " + (end - start) + " ns");
    }

    public void runMultipleTests() {

        int[] sizes = {10, 30, 100};

        for (int size : sizes) {

            System.out.println("\n======================");
            System.out.println("Graph Size: " + size);
            System.out.println("======================");

            Graph g = createGraph(size);

            if (size == 10) {
                System.out.println("\nGraph Structure:");
                g.printGraph();
            }

            runTraversals(g);
        }
    }

    public Graph createGraph(int size) {

        Graph g = new Graph();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1);
        }

        return g;
    }

    public void printResults() {
        System.out.println("\nExperiments completed.");
    }
}