package Graph.EdgeWeightDigraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AcyclicLP {

    public DirectedEdge[] edgeTo;
    public double[] distTo;


    public AcyclicLP(EdgeWeightDigraph graph, int start){
        edgeTo = new DirectedEdge[graph.V];
        distTo = new double[graph.V];
        Arrays.fill(distTo, Double.NEGATIVE_INFINITY);
        distTo[start] = 0.0;
        TopologicalSort top = new TopologicalSort(graph);
        System.out.print(" topo order:");
        for(int no :top.order()) System.out.print(no + ",");
        System.out.println();
        for(int node: top.order())  relax(graph,node);
    }

    /***
     * relax to find the longer edge
     * @param graph
     * @param start
     */
    public void relax(EdgeWeightDigraph graph, int start){
        for(DirectedEdge edge: graph.adj[start]){
            int end = edge.to();
            if(distTo[end] < distTo[start] + edge.weight){
                distTo[end] = Math.round((distTo[start] + edge.weight)*100.0)/100.0;
                edgeTo[end] = edge;
            }
        }
    }

    public double distTo(int end){return distTo[end];}

    public boolean hasPathTo( int end){ return distTo[end] < Double.POSITIVE_INFINITY;}

    public Iterable<DirectedEdge> pathTo(int start, int end){
        if(!hasPathTo(end)) return null;
        List<DirectedEdge> path = new ArrayList<>();
        for(DirectedEdge edge = edgeTo[end]; edge !=null; edge = edgeTo[edge.from()]){
            path.add(0,edge);
            if(edge.from() == start) break;
        }
        return path;
    }

    public void pathFromStartToAllOtherNode(EdgeWeightDigraph graph,  int start){
        System.out.println("All path from " + start + " to other nodes: ");
        for(int v = 0; v < graph.V; v++) {
            System.out.print(start + " to " + v + " with total distance (" + distTo[v]+") :");
            if (pathTo(start, v) != null) {
                for (DirectedEdge edge : pathTo(start, v)) {
                    System.out.print("[" + edge.from() +","+edge.to()+"," + edge.weight+"]");
                    System.out.print(" , ");
                }
                System.out.println();
            }else System.out.println();
        }
    }

    public static void main(String[] args){
        EdgeWeightDigraph graph = new EdgeWeightDigraph(8);
        graph.addEdge(new DirectedEdge(5,4,0.35));
        graph.addEdge(new DirectedEdge(4,7,0.37));
        graph.addEdge(new DirectedEdge(5,7,0.28));
        graph.addEdge(new DirectedEdge(5,1,0.32));
        graph.addEdge(new DirectedEdge(4,0,0.38));
        graph.addEdge(new DirectedEdge(0,2,0.26));
        graph.addEdge(new DirectedEdge(3,7,0.39));
        graph.addEdge(new DirectedEdge(1,3,0.29));
        graph.addEdge(new DirectedEdge(7,2,0.34));
        graph.addEdge(new DirectedEdge(6,2,0.40));
        graph.addEdge(new DirectedEdge(3,6,0.52));
        graph.addEdge(new DirectedEdge(6,0,0.58));
        graph.addEdge(new DirectedEdge(6,4,0.493));
        graph.show();
        AcyclicLP asp = new AcyclicLP(graph,5);
        asp.pathFromStartToAllOtherNode(graph,5);
    }
}
