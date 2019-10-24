package Graph.DirectGraph;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraph {
    public int V;
    public int E;
    public List<Integer>[] adj;

    public DirectedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for(int v = 0; v < V; v++) adj[v] = new ArrayList<>();
    }

    public int V() {return this.V;}
    public int E(){return this.E;}

    // v->w
    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }
    public DirectedGraph reverse(){
        DirectedGraph reverseGraph = new DirectedGraph(V);
        for(int v = 0; v < V;v++){
            for(int w: adj[v]) reverseGraph.addEdge(w,v);
        }
        return reverseGraph;
    }

    public void show(){
        System.out.println("Graph in the form of adjacency list: ");
        for(int v = 0; v < V; v++){
            System.out.print(v + " : ");
            for(int adjV: adj[v]) System.out.print(adjV + ",");
            System.out.println();
        }

    }
}
