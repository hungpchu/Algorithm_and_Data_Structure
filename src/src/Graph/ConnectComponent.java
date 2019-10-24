package Graph;

public class ConnectComponent {

    public int countConnectComponent;
    public boolean[] marked;
    public int[] connectComponentid;

    public ConnectComponent(Graph graph){
        marked = new boolean[graph.V()];
        connectComponentid = new int[graph.V()];
        for(int i = 0; i < graph.V();i++){
            if(!marked[i]){
                dfs(graph,i);
                countConnectComponent++;
            }
        }
    }

    public void dfs(Graph graph, int startNode){
        marked[startNode] = true;
        connectComponentid[startNode] = countConnectComponent;
        for(int neigh: graph.adj[startNode]){
            if(!marked[neigh]) dfs(graph, neigh);
        }
    }

    public int connectComponentID(int node){return connectComponentid[node];}

    public boolean inTheSameConnectComponent(int node1,int node2){return connectComponentid[node1] == connectComponentid[node2];}

    public int numberOfConnectComponent(){return this.countConnectComponent;}

}
