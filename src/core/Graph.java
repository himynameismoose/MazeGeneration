package core;

import java.util.*;

/**
 * @author Mershelle Rivera
 * @version 1.0
 *
 * Graph structure that contains edges and vertices
 */
public class Graph
{
    private Map<Integer, LinkedList<Edge>> adjacencyLists;
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    /**
     * Constructor for a graph that initializes list
     *
     * @param cols int number of columns/rows in the graph
     */
    public Graph(int cols)
    {
        adjacencyLists = new HashMap<>();
        this.source = cols * cols - 1;
    }

    /**
     * Adds a vertex to the graph
     *
     * @param element int vertex
     */
    public void addVertex(int element)
    {
        if (!hasVertex(element))
        {
            adjacencyLists.put(element, new LinkedList<>());
        }
    }

    /**
     * Adds an edge
     *
     * @param source int source
     * @param dest   int destination
     */
    public void addEdge(int source, int dest)
    {
        if (!hasVertex(source) || !hasVertex(dest))
        {
            throw new IllegalArgumentException("The vertex does not exist: " + source + ", " + dest);
        }

        Edge newEdge = new Edge(source, dest);
        Edge reversedNewEdge = new Edge(dest, source);
        LinkedList<Edge> adjListSource = adjacencyLists.get(source);
        LinkedList<Edge> adjListDest = adjacencyLists.get(dest);

        if (!adjListSource.contains(newEdge) && !adjListDest.contains(reversedNewEdge))
        {
            adjListSource.add(newEdge);
            adjListDest.add(reversedNewEdge);
        }
    }

    /**
     * Checks whether vertex is present or not
     *
     * @param element int vertex to add
     * @return true/false is the vertex present or not
     */
    public boolean hasVertex(int element)
    {
        return adjacencyLists.containsKey(element);
    }

    /**
     * Checks whether such edge exist in vertex or not
     *
     * @param vertex int vertex to check
     * @param edge   int destination of an edge
     * @return true/false does edge exist or not
     */
    public boolean hasEdge(int vertex, int edge)
    {
        if (hasVertex(vertex) && hasVertex(edge))
        {
            LinkedList<Edge> adjacencyList = adjacencyLists.get(vertex);

            // if edge exist for this vertex
            return adjacencyList.contains(new Edge(vertex, edge));
        }

        return false;
    }

    // Helper method to return set of edges for a vertex
    private LinkedList<Edge> getEdges(int vertex)
    {
        return adjacencyLists.get(vertex);
    }

    /**
     * list of vertices that solves the graph
     *
     * @return Iterable<Integer> list of vertices that solves the graph
     */
    public Iterable<Integer> runBFS()
    {
        this.marked = new boolean[this.size()];
        edgeTo = new int[this.size()];
        bfs(this.source);
        int destination = 0;

        return pathTo(destination);
    }

    // Helper method to run bfs search algorithm
    private void bfs(int source)
    {
        LinkedList<Integer> queue = new LinkedList<>();
        this.marked[source] = true;
        queue.add(source);

        while (!queue.isEmpty())
        {
            int vertex = queue.pop();

            for (Edge edge : getEdges(vertex))
            {
                if (!marked[edge.getDest()])
                {
                    marked[edge.getDest()] = true;
                    edgeTo[edge.getDest()] = vertex;
                    queue.add(edge.getDest());
                }
            }
        }
    }

    /**
     * run DFS algorithm to solve the graph
     *
     * @return Iterable<Integer> list of vertices that solves the graph
     */
    public Iterable<Integer> runDFS()
    {
        this.marked = new boolean[this.size()];
        edgeTo = new int[this.size()];
        dfs(this.source);
        int destination = 0;

        return pathTo(destination);
    }

    // Helper method to run dfs
    private void dfs(int vertex)
    {
        marked[vertex] = true;
        LinkedList<Edge> neighbors = getEdges(vertex);

        for (Edge edge : neighbors)
        {
            if (!marked[edge.getDest()])
            {
                edgeTo[edge.getDest()] = vertex;
                dfs(edge.getDest());
            }
        }
    }

    // Helper method to return stack of elements to solve graph
    private Stack<Integer> pathTo(int destination)
    {
        Stack<Integer> path = new Stack<>();

        if (!marked[destination])
            return null;

        for (int i = destination; i != source; i = edgeTo[i])
            path.push(i);

        path.push(source);

        return path;
    }

    /**
     * Size of the graph
     *
     * @return int size
     */
    public int size()
    {

        return this.adjacencyLists.size();
    }

    /**
     * Class that represents an edge between 2 elements
     */
    public static class Edge
    {
        private int source;
        private int dest;

        /**
         * Constructor that creates an edge between source and destination
         *
         * @param source int source
         * @param dest   int destination
         */
        public Edge(int source, int dest)
        {
            this.source = source;
            this.dest = dest;
        }

        /**
         * Returns destination of the edge
         *
         * @return int destination
         */
        public int getDest()
        {
            return dest;
        }

        public int hashCode() {
            return Objects.hash(source, dest);
        }

        public boolean equals(Object other) {
            if (this == other)
                return true;

            if (other == null || getClass() != other.getClass())
                return false;

            Edge otherEdge = (Edge) other;

            return Objects.equals(source, otherEdge.source) && Objects.equals(dest, otherEdge.dest);
        }

        public String toString() {
            return "Edge{source=" + source + ", dest=" + dest + "}";
        }
    }

    public String toString() {
        return "Graph{adjacencyLists=" + adjacencyLists + "}";
    }
}
