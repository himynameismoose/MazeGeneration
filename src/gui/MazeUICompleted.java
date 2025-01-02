package gui;

import core.DisjointSet;
import core.Graph;
import generation.AlgorithmType;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.Stack;

/**
 * @author Mershelle Rivera
 * @version 1.0
 *
 * Class that generates and solves the maze
 */
public class MazeUICompleted extends MazeUI
{
    private Graph graph;
    private DisjointSet disjointSet;
    private Random random = new Random();

    @Override
    public void runAlgorithm(AlgorithmType type)
    {
        switch (type)
        {
            case GENERATE_MAZE:
                generateMaze();
                break;
            case BFS:
                solveBFS();
                break;
            case DFS:
                solveDFS();
                break;
        }
    }

    // generates graph and draws maze on the gui
    private void generateMaze()
    {
        this.clearScreen();
        graph = new Graph(this.getCols());
        disjointSet = new DisjointSet(this.getRows() * this.getCols());
        // draw the background
        this.drawBackgroundGrid();
        this.setStrokeColor(new Color(0.0, 0.0, 0.0, 1));
        buildMaze();

        // draw maze walls
        for (int i = 0; i < this.getCols() * this.getRows(); i++)
        {
            boolean[] walls = getWalls(i);
            this.drawCell(i, walls);
        }
    }

    // add vertices to the graph and unions graph until 1 set left
    private void buildMaze()
    {
        // add vertices
        for (int i = 0; i < this.getRows() * this.getCols(); i++)
        {
            graph.addVertex(i);
        }

        // join sets/graph until only 1 graph left
        while (disjointSet.count() != 1)
        {
            int sourceRandom = random.nextInt(this.getRows() * getCols());
            int destRandom = getRandomNeighbor(sourceRandom);

            // if union is successful, add edge to undirected graph
            if (disjointSet.union(sourceRandom, destRandom))
                graph.addEdge(sourceRandom, destRandom);
        }
    }

    // return 1 random neighbor
    private int getRandomNeighbor(int index)
    {
        int randomNeighbor = random.nextInt(4);
        int[] wallsIndex = new int[4];

        // get random
        wallsIndex[0] = (index / this.getCols()) == ((index - 1) / this.getCols()) ? index - 1 : -1;
        wallsIndex[1] = (index / this.getCols()) == ((index + 1) / this.getCols()) ? index + 1 : -1;
        wallsIndex[2] = index - this.getCols();
        wallsIndex[3] = (index + this.getCols()) < (this.getCols() * this.getRows()) ? index + this.getCols() : -1;

        while (wallsIndex[randomNeighbor] < 0)
            randomNeighbor = random.nextInt(4);

        return wallsIndex[randomNeighbor];
    }

    public void solveBFS()
    {
        Stack<Integer> vertices = (Stack<Integer>) graph.runBFS();

        this.setFillColor(Color.YELLOW);

        for (int vertex : vertices)
            this.fillCell(vertex);
    }

    public void solveDFS()
    {
        Stack<Integer> vertices = (Stack<Integer>) graph.runDFS();

        this.setFillColor(Color.YELLOW);

        for (int vertex : vertices)
            this.fillCell(vertex);
    }

    /**
     * Returns walls north, east, south, west
     *
     * @param vertex int vertex to get walls for
     * @return bool[] array of walls
     */
    private boolean[] getWalls(int vertex)
    {
        boolean[] walls = {true, true, true, true};
        // north
        walls[0] = !graph.hasEdge(vertex, vertex - this.getCols());
        // east
        walls[1] = !graph.hasEdge(vertex, vertex + 1);
        // south
        walls[2] = !graph.hasEdge(vertex, vertex + this.getCols());
        // west
        walls[3] = !graph.hasEdge(vertex, vertex - 1);

        return walls;
    }

    public String toString() {
        return "MazeUICompleted{graph=" + graph + ", disjointSet=" + disjointSet + ", rand=" + random + "}";
    }
}
