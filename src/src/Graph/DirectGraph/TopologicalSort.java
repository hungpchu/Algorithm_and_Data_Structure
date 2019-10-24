package Graph.DirectGraph;

public class TopologicalSort {

    public Iterable<Integer> order;

    public TopologicalSort(DirectedGraph graph){
        DirectedCycle directedCycle = new DirectedCycle(graph);
        // ensure the graph does not have cycle or DAG
        if(!directedCycle.hasCycle()){
            DepthFirstOrder dfsOrder = new DepthFirstOrder(graph);
            order = dfsOrder.reversePost();
        }
    }

    public Iterable<Integer> order(){return this.order;}
}
