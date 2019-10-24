package Graph.EdgeWeightDigraph;

public class TopologicalSort {

    public Iterable<Integer> order;

    public TopologicalSort(EdgeWeightDigraph graph){
            DepthFirstOrder dfsOrder = new DepthFirstOrder(graph);
            order = dfsOrder.reversePost();

    }

    public Iterable<Integer> order(){return this.order;}
}