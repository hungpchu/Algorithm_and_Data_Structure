package Graph.DirectGraph;

import Graph.Cycle;

import java.util.Stack;

public class DirectedCycle {

    public boolean[] marked;
    public int[] parent;
    public Stack<Integer> cycle;
    public boolean[] onStack;
    public boolean hasCycle;

    public DirectedCycle(DirectedGraph graph){
        onStack = new boolean[graph.V()];
        parent = new int[graph.V()];
        marked = new boolean[graph.V()];
        cycle = new Stack<>();
        for(int v = 0; v < graph.V(); v++) if(!marked[v]) dfs(graph,v);
    }

    public void dfs(DirectedGraph graph, int node){

        // since we dfs through this node then this node should
        // be on stack
        onStack[node] = true;
        // marked the node as visited
        marked[node] = true;
        // traverse through the neigh of the node
        for(int neigh: graph.adj[node]){
            // if the cycle stack is not empty then we have cycle
             if (this.hasCycle()) return;
             else if (!marked[neigh]){
                // assign node as neigh parent to check cycle later
                parent[neigh] = node;
                // traverse through unvisited node
                dfs(graph,neigh);
            // if neigh is already visited and onstack then trace back to
            // check if the parent of node is the same as neigh
            }else if (onStack[neigh]){
//                System.out.println("neigh = "+ neigh + " node = "+ node);
                // put all the vertex in the cycle to the stack
                for(int vertex = node; vertex != neigh; vertex = parent[vertex]) cycle.push(vertex);
                cycle.push(neigh);
                cycle.push(node);
                if(cycle.size() <= 3) cycle = new Stack<>();
                else {
                    System.out.print("The cycle is ");
                    for (int vertex : cycle) System.out.print(vertex + ",");
                    System.out.println();
                }

            }
        }
        onStack[node] = false;
    }

    public boolean hasCycle(){return cycle.size() != 0; }

    // use to loop through stack as the iterable
    public Iterable<Integer> cycle(){
        return cycle;
    }

    public static void main(String[] args){
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(3,1);
        graph.addEdge(3,4);
        graph.addEdge(4,2);

        graph.show();

        DirectedCycle directCycle = new DirectedCycle(graph);
        System.out.println("Is there a directed cycle in the graph? " + directCycle.hasCycle());
    }
}
