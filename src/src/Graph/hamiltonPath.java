package Graph;

public class hamiltonPath {
    public int maxPath;
    public boolean[] marked;

    public hamiltonPath(Graph graph){
        marked = new boolean[graph.V()];
        for(int v = 0; v < graph.V();v++){
            if(!marked[v]) dfs(graph,v,1);
        }
    }

    public void dfs(Graph graph, int node, int depth){
        marked[node] = true;
        maxPath = Math.max(maxPath,depth);
        for(int neighbor: graph.adj[node]){
            if(!marked[neighbor]) dfs(graph,neighbor,depth+1);
        }
        // return marked[node] to false for new visit
        marked[node] = false;
    }


}
