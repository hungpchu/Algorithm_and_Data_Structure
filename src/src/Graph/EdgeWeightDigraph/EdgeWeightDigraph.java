package Graph.EdgeWeightDigraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EdgeWeightDigraph {
    public int V;
    public int E;
    public List<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int V){
        this.V = V;
        this.E = 0;
        adj = new List[V];
        for(int v = 0; v < V;v++) adj[v] = new ArrayList<>();
    }

    public void addEdge(DirectedEdge edge){
        // add to the beginning like the property of bag
        adj[edge.from()].add(0,edge);
        E++;
    }

    public void show(){
        System.out.println("Edge weight directed graph looks like: ");
        for(int v = 0; v < V; v++){
            System.out.print(v + ": ");
            if(adj[v].size() > 0){
                for(DirectedEdge edge: adj[v]){
                  System.out.print("[" + edge.node2 + ","+ edge.weight + "]");
                }
            }
            System.out.println();
        }
    }


    public static void main(String[] args){

        EdgeWeightDigraph graph = new EdgeWeightDigraph(8);
        graph.addEdge(new DirectedEdge(4,5,0.35));
        graph.addEdge(new DirectedEdge(5,4,0.35));
        graph.addEdge(new DirectedEdge(4,7,0.37));
        graph.addEdge(new DirectedEdge(5,7,0.28));
        graph.addEdge(new DirectedEdge(7,5,0.28));
        graph.addEdge(new DirectedEdge(5,1,0.32));
        graph.addEdge(new DirectedEdge(0,4,0.38));
        graph.addEdge(new DirectedEdge(0,2,0.26));
        graph.addEdge(new DirectedEdge(7,3,0.39));
        graph.addEdge(new DirectedEdge(1,3,0.29));
        graph.addEdge(new DirectedEdge(2,7,0.34));
        graph.addEdge(new DirectedEdge(6,2,0.40));
        graph.addEdge(new DirectedEdge(3,6,0.52));
        graph.addEdge(new DirectedEdge(6,0,0.58));
        graph.addEdge(new DirectedEdge(6,4,0.493));

        graph.show();

    }
}
