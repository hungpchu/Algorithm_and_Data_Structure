package Graph.NegativeEdgeWeightDiGraph;

import Graph.EdgeWeightDigraph.DirectedEdge;
import Graph.EdgeWeightDigraph.EdgeWeightDigraph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArbitrageOpportunity {

    public static void main(String[] args){
        int V = StdIn.readInt();
        String[] currencyName = new String[V];
        EdgeWeightDigraph graph = new EdgeWeightDigraph(V);
        for(int currencyNode = 0; currencyNode < V; currencyNode++){
            currencyName[currencyNode] = StdIn.readString();
            for(int currencyNeigh =0; currencyNeigh < V; currencyNeigh++){
                double currencyRate = StdIn.readDouble();
                /*** replace weight by logarithm-negated -> compute the path by multiply edge weight with original value
                 * of edge weight  will be the same like adding the log value of edge weight
                 *  Transform edge of log value will have negative and positive value -> negative cycle = arbitrage opportunity
                 * */
                DirectedEdge edge = new DirectedEdge(currencyNode,currencyNeigh, -Math.log(currencyRate));
                graph.addEdge(edge);
            }
        }

        graph.show();

        BellmanFordSP bellmanFordSP = new BellmanFordSP(graph,0);
        if(bellmanFordSP.hasNegativeCycle()){
            /*** example input of 1000 US
             */
            double stake = 1000.0;
            /***
             * cycle with all negative edge will bring out the best profit when Math.exp to positive value
             * the profit will be maximized when the sum of cycle is minimized
             */
            for(DirectedEdge edge: bellmanFordSP.negativeCycle()){
                if(edge != null) {
//                    System.out.println("edge weight = " + -edge.weight);
                    System.out.println("edge weight exp = " + Math.exp(-edge.weight));
                    StdOut.printf("%10.5f %s", stake, currencyName[edge.from()]);
                    stake *= Math.exp(-edge.weight);
                    StdOut.printf("= %10.5f %s\n", stake, currencyName[edge.to()]);
                }
            }
        }else StdOut.println("No arbitrary opportunity");
    }
}
