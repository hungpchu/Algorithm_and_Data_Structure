package Graph;

/***
 * check if the graph is bipartite
 * A Bipartite Graph is a graph whose vertices can be divided into two independent set
 */
public class Bipartite {

    public boolean[] color;
    public boolean[] marked;
    public boolean is2Color;

     public Bipartite(Graph graph){
         is2Color = true;
         // init boolean array will have all the value be false
        color = new boolean[graph.V()];
        marked = new boolean[graph.V()];
        for(int node = 0; node < graph.V(); node++) if(!marked[node]) dfsColor(graph,node);
    }

    /***
     * idea is having neighbor's color different from node
     * if the node has the same color with the neighbor then it is not bipartite
     * else if node's color is different than that of neighbor then it is bipartite
     * @param graph
     * @param node
     */
    public void dfsColor(Graph graph, int node){
         marked[node] = true;
         for(int neigh: graph.adj[node]){
             if(!marked[neigh]){
                 // marked color of neighbor differ from the node
                 color[neigh] = !color[node];
                 dfsColor(graph,neigh);
                 // if already visited and color is the same meaning not bipartite
             }else if(color[neigh] == color[node]) is2Color = false;

         }
    }

    public boolean isIs2Color(){ return is2Color; }
}
