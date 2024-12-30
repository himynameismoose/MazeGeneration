package core;

/**
 * Class that keeps track of the sets in the graph and provide functionality to union sets
 *
 * @author Mershelle Rivera
 * @version 1.0
 */
public class DisjointSet
{

    /**
     * Constructor that sets the size of the array
     *
     * @param size int number of separate sets and size of the array
     */
    public DisjointSet(int size)
    {

    }

    /**
     * Union method that checks whether 2 elements belong to the same set and if not, joins them together
     *
     * @param first  int first vertex to join
     * @param second int second vertex to join
     * @return true/false was the union performed or not
     */
    public boolean union(int first, int second)
    {

        return false;
    }

    /**
     * @param element int vertex to find the root for
     * @return int root or parent of the element passed in.
     */
    public int find(int element)
    {

        return element;
    }

    /**
     * Returns number of separate sets in this structure
     *
     * @return int number of disjoint sets
     */
    public int count()
    {

        return 0;
    }
}
