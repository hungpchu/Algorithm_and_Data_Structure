package Graph.DirectGraph;

public class StrongComponent {
    public boolean[] marked;
    public int[] id;
    public int count;

    /***
     * 2 nodes are strongly connected if there is a path from v to w and w to v
     * @param graph
     */
    public StrongComponent(DirectedGraph graph){
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph);
        System.out.println("Strong components = ");
        for(int s: depthFirstOrder.reversePost()){
            if(!marked[s]){
                dfs(graph,s);
                count++;
                System.out.println();
            }
        }
    }

    public void dfs(DirectedGraph graph, int node){
        System.out.print(node + ",");
        marked[node] = true;
        id[node] = count;
        for(int neigh: graph.adj[node]) if(!marked[neigh]) dfs(graph,neigh);
    }

    public int countComponent(){return count;}
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(13);
        graph.addEdge(0, 5);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(4, 2);
        graph.addEdge(4, 3);
        graph.addEdge(5, 4);
        graph.addEdge(6, 0);
        graph.addEdge(6, 9);
        graph.addEdge(6, 4);
        graph.addEdge(7, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 7);
        graph.addEdge(8, 9);
        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(10, 9);
        graph.addEdge(11, 12);
        graph.addEdge(12, 9);
//        graph.reverse().show();

        StrongComponent strongComponent = new StrongComponent(graph);
        System.out.println(strongComponent.count);

    }
}
