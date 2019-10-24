package Graph.EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightGraph {

    public int V;
    public int E;
    public List<Edge>[] adj;

    public EdgeWeightGraph(int V){
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for(int v = 0; v< V; v++) adj[v] = new ArrayList<>();
    }

    public void addEdge(Edge edge){
        int node1 = edge.node1;
        int node2 = edge.node2;
        adj[node1].add(edge);
        adj[node2].add(edge);
        E++;
    }


    public void show(){
        System.out.println("Edge weight graph looks like: ");
        for(int v = 0; v < V; v++){
            System.out.print(v + ": ");
            if(adj[v].size() > 0){
                for(Edge edge: adj[v]){
                    if(v == edge.node2()) System.out.print(edge.show() +", ");
                    else System.out.print("[" + edge.node2() + ","+ edge.weight + "]");
                }
            }
            System.out.println();
        }
    }

}
