package Graph;

public class Cycle {

    public boolean[] marked;
    public boolean hasCycle;

    public Cycle(Graph graph){
        marked = new boolean[graph.V()];
        for(int i = 0; i < graph.V(); i++){
            if(!marked[i]) dfsCycle(graph,i,i);
        }
    }

    /***
     * Idea: For all visited vertex v, if there is a visited vertex n
     * that n is not parent of v then there is cycle
     * @param graph
     * @param vertex
     * @param parent
     */
    public void dfs(Graph graph, int vertex, int parent){
//        System.out.println(" parent = " + parent + " vertex = " + vertex);
        marked[vertex] = true;
        for(int neighbor: graph.adj[vertex]){
//           System.out.println( " vertex = " + vertex + " neighbor = "+ neighbor);
            if(!marked[neighbor]) dfs(graph,neighbor,vertex);
            else if(neighbor != parent){
                System.out.println(" parent = " + parent + " vertex = " + vertex + " neighbor = "+ neighbor);
                hasCycle = true;
            }
        }
    }

    public void dfsCycle(Graph graph, int vertex, int parent){
        marked[vertex] = true;
        for(int neighbor: graph.adj[vertex]){
            if(!marked[neighbor]) dfs(graph,neighbor,vertex);
            else {
               for(int child: graph.adj[neighbor]) if(child == parent) hasCycle = true;
            }
        }
    }

    public boolean isHasCycle(){
        return hasCycle;
    }


}
