package Graph.NegativeEdgeWeightDiGraph;

import Graph.EdgeWeightDigraph.DirectedEdge;
import Graph.EdgeWeightDigraph.EdgeWeightDigraph;



import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/***
 * Worst time: O(VE) since there will be negative cycle and
 *   we will check twice with cost = V so that will be VE
 * Average time: O(V+E) since it look for most  ecently up to
 *   dated node with distTo change in the queue and there is no negative cycle
 *
 *  Main idea: check to relax neighbor of the most recently added node in the queue
 *
 *  Space: O(V) since we need queue to store all the node in the worst case
 *  Worst case: relaxes all E edges in each of V passes
 *
 *  Restriction: No negative cycle.
 */
public class BellmanFordSP {
    public double disTo[];
    public DirectedEdge edgeTo[];
    public boolean onQueue[];
    public Queue<Integer> queue;
    public int cost;
    public Iterable<DirectedEdge> cycle;

    /***
     * most recent updated
     * @param graph
     * @param start
     */
    public BellmanFordSP(EdgeWeightDigraph graph, int start){
        disTo = new double[graph.V];
        edgeTo = new DirectedEdge[graph.V];
        queue = new LinkedList<>();
        // all the value in the onQueue is false
        onQueue = new boolean[graph.V];
        Arrays.fill(disTo, Double.POSITIVE_INFINITY);
        disTo[start] = 0.0;
        onQueue[start] = true;
        queue.add(start);
        /***
         * avoid infinity loop with hasNegativeCycle
         * -> In the case of negative cycle then queue will never be empty since
         * while loop will relax just inside the negative cycle with onQueue set to false
         * -> Then when we detect negative cycle -> we will break out of the while loop when the value of
         * cost + V
         */
        while(!queue.isEmpty() && !this.hasNegativeCycle()){
            int connectedNode = queue.remove();
            /***
             * Set the connectedNode to be false since we want to visit this node again
             * -> Why visit again? Since there may be negative-weight edge coming from
             * its parent node then there will a new shortest path
             */
            onQueue[connectedNode] = false;
//            System.out.println("Most updated node to be relax and set to be not On queue = " +connectedNode);
            relax(graph,connectedNode);
        }

    }

    public void relax(EdgeWeightDigraph graph, int node){

        for(DirectedEdge edge: graph.adj[node]){
//            System.out.print("queue  before relax= ");
//            for(int element: queue) System.out.print(element+",");
//            System.out.println();
//            System.out.println(" node = " + node + " edge considered to be relax = "+ edge.from() + "-" + edge.to());
            int end = edge.to();
            if(disTo[end] > disTo[node] + edge.weight){
//                System.out.println(" node = " + node + " relax edge = "+ edge.from() + "-" + edge.to());
                disTo[end] = disTo[node] + edge.weight;
                edgeTo[end] = edge;
                if(!onQueue[end]){
//                    System.out.println("element dc add = "+end);
                    queue.add(end);
                    onQueue[end] = true;
                }
            }
//            System.out.print("queue  after relax= ");
//            for(int element: queue) System.out.print(element+",");
//            System.out.println();
//            System.out.println("cost = "+ cost + " cycle = "+ hasNegativeCycle());
            /*** call the findNegative Cycle to check for negative cycle after running through V number of cost
             */
            if(cost++ % graph.V == 0) {
                findNegativeCycle();
                if (hasNegativeCycle()) return;  // found a negative cycle
            }
        }

    }

    /***
     * avoid infinity loop
     */
    public void findNegativeCycle(){
        // number of vertex
        int V = edgeTo.length;
        // graph contain all the current shortest path
        EdgeWeightDigraph sptGraph = new EdgeWeightDigraph(V);
        // create new graph with as current graph
        for(int v = 0; v  < V; v++){
            // add edge been relaxed to check cycle
            if(edgeTo[v] != null) sptGraph.addEdge(edgeTo[v]);
        }
        EdgeWeightedCycleFinder cycleFinder = new EdgeWeightedCycleFinder(sptGraph);
        cycle = cycleFinder.cycle;

    }

    public boolean hasNegativeCycle(){ return cycle != null; }
    public Iterable<DirectedEdge> negativeCycle(){ return cycle;}


    public static void main(String[] args){
        EdgeWeightDigraph graph = new EdgeWeightDigraph(8);
        // example with negative cycle -> 4-5-4
//        graph.addEdge(new DirectedEdge(4,5,0.35));
//        graph.addEdge(new DirectedEdge(5,4,-0.66));
//        graph.addEdge(new DirectedEdge(4,7,0.37));
//        graph.addEdge(new DirectedEdge(5,7,0.28));
//        graph.addEdge(new DirectedEdge(7,5,0.28));
//        graph.addEdge(new DirectedEdge(5,1,0.32));
//        graph.addEdge(new DirectedEdge(0,4,0.38));
//        graph.addEdge(new DirectedEdge(0,2,0.26));
//        graph.addEdge(new DirectedEdge(7,3,0.39));
//        graph.addEdge(new DirectedEdge(1,3,0.29));
//        graph.addEdge(new DirectedEdge(2,7,0.34));
//        graph.addEdge(new DirectedEdge(6,2,0.40));
//        graph.addEdge(new DirectedEdge(3,6,0.52));
//        graph.addEdge(new DirectedEdge(6,0,0.58));
//        graph.addEdge(new DirectedEdge(6,4,0.93));

        // example with negative-weight edge and no negative cycle
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
        graph.addEdge(new DirectedEdge(6,2,-1.20));
        graph.addEdge(new DirectedEdge(3,6,0.52));
        graph.addEdge(new DirectedEdge(6,0,-1.40));
        graph.addEdge(new DirectedEdge(6,4,-1.25));

        BellmanFordSP bellmanFordSP = new BellmanFordSP(graph,0);

        for(int v = 0; v < graph.V; v++){
            System.out.print("edgeTo[" + v + "] = ");
            if(bellmanFordSP.edgeTo[v] != null) System.out.print("[" + bellmanFordSP.edgeTo[v].from() + "," + bellmanFordSP.edgeTo[v].to() + "," + bellmanFordSP.disTo[v] + "]");
            else System.out.print("No edge");
            System.out.println();

        }

    }
 }
