package Graph.MinimumSpanningTree;

import Graph.EdgeWeightedGraph.Edge;
import Graph.EdgeWeightedGraph.EdgeWeightGraph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/***
 * Time: ElogE -> time to compare edge in the priority queue
 * Space: O(E) -> at most all the edge will be store in the priority queue
 */
public class PrimMST {

    public boolean[] marked;
    public Queue<Edge> mst;
    public PriorityQueue<Edge> pq;

    public PrimMST(EdgeWeightGraph graph){
        pq = new PriorityQueue<>((a,b) -> a.compareTo(b));
        mst = new LinkedList<>();
        marked = new boolean[graph.V];
        visitDFS(graph,0);
        while(!pq.isEmpty()){
            Edge minEdge = pq.remove();
            // remove the minEdge from the pq
            int node1 = minEdge.node1, node2 = minEdge.node2;
            // if already visit then we no need to add the minEdge to the MST since
            // we already have the edge in before
            if(marked[node1] && marked[node2]) continue;
            // if not visit then add the edge to the mst
            mst.add(minEdge);
            // for node1 and node2 -> visited if not visited
            if(!marked[node1]) visitDFS(graph,node1);
            if(!marked[node2]) visitDFS(graph,node2);
        }

    }

    public void visitDFS(EdgeWeightGraph graph, int node){
        marked[node] = true;
        for(Edge edge: graph.adj[node]){
            if(!marked[edge.other(node)]) pq.add(edge);
        }
    }

    public Iterable<Edge> MST(){return mst;}

    public void show(){
        System.out.println("Minimum spanning tree using Prim is: ");
        for(Edge edge: MST()) System.out.println(edge.showFull());
    }



    public static void main(String[] args){
        EdgeWeightGraph graph = new EdgeWeightGraph(8);
        graph.addEdge( new Edge(4,5,0.35));
        graph.addEdge( new Edge(4,7,0.37));
        graph.addEdge( new Edge(5,7,0.28));
        graph.addEdge( new Edge(0,7,0.16));
        graph.addEdge( new Edge(1,5,0.32));
        graph.addEdge( new Edge(0,4,0.38));
        graph.addEdge( new Edge(2,3,0.17));
        graph.addEdge( new Edge(1,7,0.19));
        graph.addEdge( new Edge(0,2,0.26));
        graph.addEdge( new Edge(1,2,0.36));
        graph.addEdge( new Edge(1,3,0.29));
        graph.addEdge( new Edge(2,7,0.34));
        graph.addEdge( new Edge(6,2,0.40));
        graph.addEdge( new Edge(3,6,0.52));
        graph.addEdge( new Edge(6,0,0.58));
        graph.addEdge( new Edge(6,4,0.93));
        graph.show();
        PrimMST primMST = new PrimMST(graph);
        primMST.show();
    }
}
