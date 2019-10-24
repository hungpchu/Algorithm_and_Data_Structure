package Graph.DirectGraph;


/*** time:O(V+E)
 * topological is good for job-scheduling application
 * Spcific the tasks and precedence constraints
 */
public class DirectedDFS {
    public boolean[] marked;
    public int[] parent;

    public DirectedDFS(DirectedGraph graph){
        marked = new boolean[graph.V()];
        parent = new int[graph.V()];
        dfsTraverse(graph);
    }

    public void dfsTraverse(DirectedGraph graph){
        for(int v = 0; v < graph.V(); v++) if(!marked[v]) directedDFS(graph,v);
    }

    public void directedDFS(DirectedGraph graph, int node ){
        marked[node]= true;
        for(int neigh: graph.adj[node]){
            if(!marked[neigh]){
                parent[neigh] = node;
                directedDFS(graph,neigh);
            }
        }
    }

    public void path(int start, int destination){
        if( start == destination) return;
        System.out.println("The path is = " + destination + ",");
        while(destination!=start){
            destination = parent[destination];
            System.out.print(destination + ",");
        }
        System.out.print(start);
        System.out.println();
    }
}
