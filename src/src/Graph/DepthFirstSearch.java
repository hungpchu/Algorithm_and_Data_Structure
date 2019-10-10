package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/***
 * Usage: find connectivity + check all path from source to sink
 */
public class DepthFirstSearch {
    // marked to check all visited vertex
    private boolean[] marked;
    // to keep track of previous vertex to source from sink
    private int[] edgeTo;
    // s means source
    private final int s;

    // constructor to init all marked + edgeTo + s
    // then using dfs to visit all the vertex and check path from source to all other vertex
    public DepthFirstSearch(Graph graph, int s){
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = s;
        dfsIteration(graph,s);
    }

    private void dfs(Graph graph, int v){
        marked[v] = true;
        //System.out.println(" v = " + v);
        for(int neighbor: graph.adj[v]){
            if(!marked[neighbor]){
                edgeTo[neighbor] = v;
                dfs(graph,neighbor);
            }
        }
    }

    private void dfsIteration(Graph graph,int v){
        marked[v] = true;
        Stack<Integer> st = new Stack<>();
        st.push(v);
        while(!st.isEmpty()){
            v = st.pop();
            for(int neighbor: graph.adj[v]){
                if(!marked[neighbor]){
                    marked[neighbor] = true;
                    edgeTo[neighbor] = v;
                    st.push(neighbor);
                }
            }
        }
    }

    // check if there is a path from source to v
    public boolean hasPathTo(int v){return marked[v];}

    // using list to add all vertex back from sink to source
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        List<Integer> path = new ArrayList<>();
        for(int x = v; x != s; x = edgeTo[x]){
            path.add(0,x);
        }
        path.add(0,s);
        return path;
    }
}
