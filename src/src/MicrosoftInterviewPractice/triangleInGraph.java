package MicrosoftInterviewPractice;
import Graph.Graph;

import java.util.*;

/***
 * Idea: Given an undirected graph, return the number of triangle in the graph.
 * Here the triangle means a cycle with 3 vertexes so we should return the number of cycle
 * contains 3 vertexes
 */
public class triangleInGraph {

    public Graph graph;
    public List<List<Integer>> allTriangle;
    public int numberOfTriangle;
    public boolean[] marked;
    public int[] parentNode;
    public triangleInGraph(int vertexNumber, int edge){
        graph = new Graph(vertexNumber);
        marked = new boolean[vertexNumber];
        allTriangle = new ArrayList<>();
        parentNode = new int[vertexNumber];
        numberOfTriangle = 0;
    }

    public void addEdge(int vertex1, int vertex2){graph.addEdge(vertex1,vertex2);}


    public List<List<Integer>> getAllTriangle(){return allTriangle;}

    public void show(){
        graph.show();

    }

    public int countTriangle(Graph graph){
        numberOfTriangle = 0;
        for(int vertex = 0; vertex < graph.V(); vertex++) if(!marked[vertex]) dfsTriangle(graph,vertex,vertex);
        return numberOfTriangle;
    }

    public void dfsTriangle(Graph graph,Integer vertex,Integer parent){
        if(marked[vertex]) return;
        marked[vertex] = true;
        // traverse through child of vertex
        for(int child: graph.adj[vertex]){
            if(!marked[child]) dfsTriangle(graph,child,vertex);
            // if child is visited then we can check its child
            else{
                for(int childOfChild: graph.adj[child]){
                    // if child of Child is parent then we have triangle since:
                    // child -> parent, parent->vertex and vertex-> child
                    if(childOfChild == parent && parent != vertex){
                        System.out.println("Triangle = "+ vertex + ","+ child + "," + parent);
                        numberOfTriangle++;
                    }
                }
            }
        }

    }

    public static void main(String[] args){
        triangleInGraph tri = new triangleInGraph(8,8);
        tri.addEdge(0,1);
        tri.addEdge(0,2);
        tri.addEdge(1,2);
        tri.addEdge(1,3);
        tri.addEdge(3,4);
        tri.addEdge(3,5);
//        tri.addEdge(4,5);
        tri.addEdge(3,2);
//        tri.addEdge(2,5);
//        tri.addEdge(0,6);
//        tri.addEdge(2,6);
//        tri.addEdge(4,7);
//        tri.addEdge(5,7);
        tri.show();
        System.out.println("number of triangle = "+  tri.countTriangle(tri.graph));

    }
}
