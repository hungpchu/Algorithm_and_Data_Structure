package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Graph.DepthFirstSearch;

// space: E + V
public class Graph  {
    private final int V;
    private int E;
    public List<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = new List[V];
        for(int v = 0; v < V; v++) adj[v] = new ArrayList<>();
    }

    public int V(){return V;}
    public int E(){return E;}

    // time: O(1)
    public void addEdge(int v, int w){
        adj[v].add(0,w);
        adj[w].add(0,v);
        Collections.sort(adj[v]);
        Collections.sort(adj[w]);
        E++;
    }

    public void show(){
        System.out.println("Graph in the form of adjacency list: ");
        for(int v = 0; v < V; v++){
            System.out.print(v + " : ");
            for(int adjV: adj[v]) System.out.print(adjV + ",");
            System.out.println();
        }

    }

    public void findAllPathforDFS(DepthFirstSearch dfs,int s) {
        System.out.println("Depth First Search Path: ");
        for (int v = 0; v < V; v++) {
            System.out.print("Path from " + s + " to " + v + " : ");
            if (dfs.hasPathTo(v)) {
                for (int x : dfs.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }

            }else System.out.print("No path");
            System.out.println();
        }
        System.out.println();
    }

    public void findAllPathforBFS(BreathFirstSearch bfs,int s) {
        System.out.println("Breath First Search Path: ");
        for (int v = 0; v < V; v++) {
            System.out.print("Path from " + s + " to " + v + " : ");
            if (bfs.hasPathTo(v)) {
                for (int x : bfs.pathTo(v)) {
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
                }

            }else System.out.print("No path");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        Graph graph = new Graph(5);
//        graph.addEdge(0,5);
        graph.addEdge(3,2);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
//        graph.addEdge(1,4);
        graph.addEdge(0,3);
        graph.addEdge(0,2);
        Bipartite bi = new Bipartite(graph);
//        graph.addEdge(9,12);
//        graph.addEdge(6,4);
//        graph.addEdge(5,4);
//        graph.addEdge(0,2);
//        graph.addEdge(11,12);
//        graph.addEdge(9,10);
//        graph.addEdge(0,6);
//        graph.addEdge(9,11);
//        graph.addEdge(7,8);
//        graph.addEdge(5,3);
//        graph.addEdge(5,9);
//        graph.addEdge(13,14);
        graph.show();
//        DepthFirstSearch dfs = new DepthFirstSearch(graph,0);
//        BreathFirstSearch bfs = new BreathFirstSearch(graph,0);
//        ConnectComponent cc = new ConnectComponent(graph);
//        Cycle cycle = new Cycle(graph);
//        graph.findAllPathforDFS(dfs,0);
//        graph.findAllPathforBFS(bfs,0);
//        System.out.println("number of connect component is " + cc.numberOfConnectComponent());
//        System.out.println("Node 12 is in connected component number "+ cc.connectComponentID(13));
//        System.out.println(" Node 4 and node 8 is connect: "+cc.inTheSameConnectComponent(4,3));
//        System.out.println(" graph has cycle: " + cycle.isHasCycle());
        System.out.println(" graph is bipartite: " + bi.isIs2Color());

        }
}
