package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreathFirstSearch {

    public boolean[] marked;
    public int[] edgeTo;
    public int s;

    public BreathFirstSearch(Graph graph, int source){
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        this.s = source;
        bfs(graph,source);
    }

    public boolean hasPathTo( int v){return marked[v];}

    public void bfs(Graph graph, int vertex){
        marked[vertex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            vertex = queue.remove();
            for(int neighbor: graph.adj[vertex]){
                if(!marked[neighbor]){
                    marked[neighbor] = true;
                    edgeTo[neighbor] = vertex;
                    queue.add(neighbor);
                }
            }
        }
    }


    public Iterable<Integer> pathTo(int vertex){
        if(!hasPathTo(vertex)) return null;
        List<Integer> path = new ArrayList<>();
        for(int v = vertex; v != s; v = edgeTo[v]){
            path.add(0,v);
        }
        path.add(0,s);
        return path;
    }
}
