package Graph.EdgeWeightDigraph;

public class DijkstraAllPairsSP {

    public DijkstraSP[] all;

    public DijkstraAllPairsSP(EdgeWeightDigraph graph){
        all = new DijkstraSP[graph.V];
        for(int v = 0; v < graph.V; v++) all[v] = new DijkstraSP(graph,v);
    }

    public Iterable<DirectedEdge> path(int start, int end){ return all[start].pathTo(end);}

    public double dist(int start, int end){ return all[start].disTo[end];}

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
        DijkstraAllPairsSP shortestPath = new DijkstraAllPairsSP(graph);
    }
}
