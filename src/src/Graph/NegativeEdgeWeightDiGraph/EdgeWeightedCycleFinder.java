package Graph.NegativeEdgeWeightDiGraph;

import Graph.EdgeWeightDigraph.DirectedEdge;
import Graph.EdgeWeightDigraph.EdgeWeightDigraph;
import edu.princeton.cs.algs4.Stack;

public class EdgeWeightedCycleFinder {

    public boolean[] onStack;
    public boolean[] marked;
    public DirectedEdge[] edgeTo;
    public int[]  parent;
    public Stack<DirectedEdge> cycle;

    public EdgeWeightedCycleFinder(EdgeWeightDigraph graph){
        onStack = new boolean[graph.V];
        edgeTo = new DirectedEdge[graph.V];
        parent = new int[graph.V];
        marked = new boolean[graph.V];

        for(int v = 0; v < graph.V; v++) if(!marked[v]) dfsCyle(graph,v);


    }

    public void dfsCyle(EdgeWeightDigraph graph, int node){
        // for loop in the whole graph
        marked[node] = true;
        // check for cycle
        onStack[node] =true;
        for(DirectedEdge edge: graph.adj[node]){
            int neigh = edge.to();
            if(cycle != null ) return;
            else if(!marked[neigh]){
                parent[neigh] = node;
                edgeTo[neigh] = edge;
                dfsCyle(graph,neigh);
            }
            else if(onStack[neigh]){
                cycle = new Stack<>();
                int v = node;
                cycle.push(edge);
                cycle.push(edgeTo[v]);
                while(v != neigh){
                    v = parent[v];
                    if(v == neigh) break;
                    cycle.push(edgeTo[v]);
                }
                System.out.println("size = "+ cycle.size());
//                if(cycle.size() < 3) cycle = new Stack<>();
//                else {
//                    System.out.print("The cycle is ");
//                    for (DirectedEdge e : cycle) e.showFull();
//                    System.out.println();
//                }
            }
        }

//        onStack[node] = false;
    }

    public boolean hasCycle(){return cycle != null; }

    public static void main(String[] args){
        EdgeWeightDigraph graph = new EdgeWeightDigraph(5);
        graph.addEdge(new DirectedEdge(0,1,0.6));
        graph.addEdge(new DirectedEdge(1,2,0.5));
        graph.addEdge(new DirectedEdge(2,3,0.7));
        graph.addEdge(new DirectedEdge(3,1,0.8));
        graph.addEdge(new DirectedEdge(3,4,0.4));
        graph.addEdge(new DirectedEdge(4,2,0.1));

        graph.show();

        EdgeWeightedCycleFinder directCycle = new EdgeWeightedCycleFinder(graph);
        System.out.println("Is there a directed cycle in the graph? " + directCycle.hasCycle());
    }
}
