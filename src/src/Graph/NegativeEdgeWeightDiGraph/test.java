package Graph.NegativeEdgeWeightDiGraph;
import edu.princeton.cs.algs4.BellmanFordSP;
import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;

public class test {
    public static void main(String[] args){
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(8);
        graph.addEdge(new DirectedEdge(4,5,0.35));
        graph.addEdge(new DirectedEdge(5,4,-0.66));
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
        graph.addEdge(new DirectedEdge(6,4,0.93));

        BellmanFordSP bellmanFordSP = new BellmanFordSP(graph,0);

//        for(DirectedEdge edge: bellmanFordSP.pathTo(4)) System.out.print("[" + edge.from() + "," + edge.to() +"," +edge.weight() +"]" + ",");

        for(int v = 1; v < graph.V(); v++){
            System.out.print("edgeTo" + v + " = ");
            if(bellmanFordSP.pathTo(v) != null){
                for(DirectedEdge edge: bellmanFordSP.pathTo(v)) System.out.print("[" + edge.from() + "," + edge.to() +"," +edge.weight() +"]" + ",");
            }
            else System.out.print("No edge");
            System.out.println();

        }
    }
}
