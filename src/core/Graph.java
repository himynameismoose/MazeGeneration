package core;

/**
 * @author Mershelle Rivera
 * @version 1.0
 *
 * Graph structure that contains edges and vertices
 */
public class Graph
{

    /**
     * Constructor for a graph that initializes list
     *
     * @param cols int number of columns/rows in the graph
     */
    public Graph(int cols)
    {

    }

    /**
     * Adds an vertex to the graph
     *
     * @param element int vertex
     */
    public void addVertex(int element)
    {

    }

    /**
     * Adds an edge
     *
     * @param source int source
     * @param dest   int destination
     */
    public void addEdge(int source, int dest)
    {

    }

    /**
     * Checks whether vertex is present or not
     *
     * @param element int vertex to add
     * @return true/false is the vertex present or not
     */
    public boolean hasVertex(int element)
    {
        return false;
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

        return false;
    }

    /**
     * list of vertices that solves the graph
     *
     * @return Iterable<Integer> list of vertices that solves the graph
     */
    public Iterable<Integer> runBFS()
    {

        return null;
    }

    /**
     * run DFS algorithm to solve the graph
     *
     * @return Iterable<Integer> list of vertices that solves the graph
     */
    public Iterable<Integer> runDFS()
    {

        return null;
    }

    /**
     * Size of the graph
     *
     * @return int size
     */
    public int size()
    {

        return 0;
    }

    /**
     * Class that represents an edge between 2 elements
     */
    public static class Edge
    {

        /**
         * Constructor that creates an edge between source and destination
         *
         * @param source int source
         * @param dest   int destination
         */
        public Edge(int source, int dest)
        {

        }

        /**
         * Returns destination of the edge
         *
         * @return int destination
         */
        public int getDest()
        {
            return 0;
        }
    }
}
