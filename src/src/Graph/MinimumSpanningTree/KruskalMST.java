package Graph.MinimumSpanningTree;

import Graph.EdgeWeightedGraph.Edge;
import Graph.EdgeWeightedGraph.EdgeWeightGraph;
import UnionFind.UnionFind;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/***
 * Time: ElogE since the time to compare edge inside the priority queue
 * Space: E to store all the edge and order them inside the priority queue
 */
public class KruskalMST {
    public Queue<Edge> mst;
    public PriorityQueue<Edge> pq;
    public HashSet<Integer> hs;

    public KruskalMST(EdgeWeightGraph graph){
        mst = new LinkedList<>();
        pq = new PriorityQueue<>((a,b)->a.compareTo(b));
        hs = new HashSet<>();
        // use the union find to construct the graph of mst
        UnionFind uf = new UnionFind(graph.V);
        // add all the edge inside the queue
        for(int v = 0; v < graph.V; v++){
            for(Edge e: graph.adj[v]) pq.add(e);
        }
        while(!pq.isEmpty() && mst.size() < graph.V - 1){
            Edge minEdge = pq.remove();
            int node1 = minEdge.node1, node2 = minEdge.node2;
            //  if already conntected then no need to add the minEdge to mst
            if(uf.isConnected(node1,node2)) continue;
            // if not then connect 2 node
            uf.connected(node1,node2);
            // then add their edge to the mst
            mst.add(minEdge);
        }
    }

    public void show(){
        System.out.println("Minimum spanning tree using Kruskal is: ");
        for(Edge edge: mst) System.out.println(edge.showFull());
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
        KruskalMST kruskalMST = new KruskalMST(graph);
        kruskalMST.show();
    }
}
