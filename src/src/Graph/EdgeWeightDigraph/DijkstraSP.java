package Graph.EdgeWeightDigraph;

import java.util.*;

/***
 * Time: ElogV -> compare of edge in priority queue
 * Space: V -> number of vertex
 *
 * Main idea: greedy and dynamic programming
 *  greedy since it choose the next node to relax and explore neighbor node
 *   base on the  min edge associated with that node from the PriorityQueue
 *  dynamic since it store all the relax edge in the priority queue
 *
 *  Problem statements: Given an edge-weighted digraph and a source vertex s
 *  -> find a directed path from s to a given target s such that total weight is min
 *
 *  Restriction: Positive edge weights.
 */
public class DijkstraSP {

    public DirectedEdge[] edgeTo;
    public double[] disTo;
    public HashMap<Double,Integer> hm;
    public PriorityQueue<Double> pq;
    public List<DirectedEdge> mst;

    public DijkstraSP(EdgeWeightDigraph graph, int start){
        mst = new ArrayList<>();
        edgeTo = new DirectedEdge[graph.V];
        disTo = new double[graph.V];
        hm = new HashMap<>();
        pq = new PriorityQueue<>();

        for(int v = 0; v < graph.V; v++) disTo[v] = Double.POSITIVE_INFINITY;
        disTo[start] = 0.0;
        pq.add(0.0);
        hm.put(0.0,start);
        while(!pq.isEmpty()){
            if(pq.peek() != 0) mst.add(edgeTo[hm.get(pq.peek())]);
            relax(graph,hm.get(pq.remove()));
        }
    }

    public void relax(EdgeWeightDigraph graph, int start){
        hm.remove(start);
        for(DirectedEdge edge: graph.adj[start]){
            int end = edge.to();
            if(disTo[end] > disTo[start] + edge.weight){
                // record oldDistance to remove if we need to
                double oldDistance = disTo[end];
                disTo[end] = disTo[start] + edge.weight;
                edgeTo[end] = edge;
                // update the priority Queue with new value of end node
                if(hm.containsKey(end)){
                        // remove oldDistance if we need updated shortest path
                        // from hashmap and priorityQueue
                        hm.remove(oldDistance);
                        pq.remove(oldDistance);
                        // update new shortest path to exist node in the priorty queue
                        // and hashmap
                        hm.put(disTo[end],end);
                        pq.add(disTo[end]);
                // if new to hashmap and priority queue then
                // just add
                }else{
                     pq.add(disTo[end]);
                     hm.put(disTo[end],end);
                }
            }
        }
    }

    public double disTo(int node){return disTo[node]; }

    public boolean hasPathTo(int node){ return disTo[node] < Double.POSITIVE_INFINITY;}

    public Iterable<DirectedEdge> pathTo(int end){
        if(!hasPathTo(end)) return null;
        System.out.println("end = "+ end);
        Stack<DirectedEdge> path = new Stack<>();
        for(DirectedEdge edge = edgeTo[end]; edge != null; edge = edgeTo[edge.from()])path.push(edge);
        return path;
    }

    public void showEdge(DijkstraSP dijk, DirectedEdge edge){ System.out.println("["+edge.from()+","+edge.to()+","+ dijk.disTo(edge.to()) + "]");}

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
        DijkstraSP shortestPath = new DijkstraSP(graph,0);

//        System.out.println("edge is ");
//        for(DirectedEdge edge: shortestPath.pathTo(7)) edge.showFull();

        System.out.println(" MST of Dijkstra look like this: ");
        for(DirectedEdge edge: shortestPath.mst) shortestPath.showEdge(shortestPath,edge);
    }
}
