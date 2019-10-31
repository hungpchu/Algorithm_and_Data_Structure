package Graph.EdgeWeightDigraph;

/***
 * Average + Worst Time: ElogV since we run DFS through number of E edges
 *   and compare if vertex is marked or not through !marked[vertex] operation.
 * Space: Use extra stack to store the reverse order of visited node using dfs node to visit
 */
public class TopologicalSort {

    public Iterable<Integer> order;

    public TopologicalSort(EdgeWeightDigraph graph){
            DepthFirstOrder dfsOrder = new DepthFirstOrder(graph);
            order = dfsOrder.reversePost();

    }

    public Iterable<Integer> order(){return this.order;}
}