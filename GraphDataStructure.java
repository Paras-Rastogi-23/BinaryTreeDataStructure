import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class Graph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack<Integer> s;
    private Queue<Integer> q;

    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        s = new Stack<Integer>();
        q = new LinkedList<Integer>();
    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false) {
                return j;
            }
        }
        return -1;
    }

    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        s.push(0);

        while (!s.isEmpty()) {
            int v = getAdjUnvisitedVertex(s.peek());

            if (v == -1) {
                s.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                s.push(v);
            }
        }
    }

    public void bfs() {
        displayVertex(0);
        q.add(0);
        vertexList[0].wasVisited = true;
        int v2;

        while (q.size() > 0) {
            int v1 = q.remove();

            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                displayVertex(v2);
                vertexList[v2].wasVisited = true;
                q.add(v2);
            }
        }
    }
}



public class GraphDataStructure {

    public static void main(String[] args) {

        Graph theGraph = new Graph();
        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');

        theGraph.addEdge(0, 1);
        theGraph.addEdge(1, 2);
        theGraph.addEdge(0, 3);
        theGraph.addEdge(3, 4);
        theGraph.addEdge(4, 5);
        theGraph.addEdge(1, 3);

        System.out.print("DFS Visits: ");
        theGraph.dfs();
        System.out.println();

        //**************************************************
        Graph theGraph2 = new Graph();
        theGraph2.addVertex('A');
        theGraph2.addVertex('B');
        theGraph2.addVertex('C');
        theGraph2.addVertex('D');
        theGraph2.addVertex('E');
        theGraph2.addVertex('F');

        theGraph2.addEdge(0, 1);
        theGraph2.addEdge(1, 2);
        theGraph2.addEdge(0, 3);
        theGraph2.addEdge(3, 4);
        theGraph2.addEdge(4, 5);
        theGraph2.addEdge(1, 3);

        System.out.print("BFS Visits: ");
        theGraph2.bfs();
        System.out.println();
    }

}
