package Graph.DirectGraph;

import Graph.DepthFirstSearch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// time:O(V+E)
public class DepthFirstOrder {

    public boolean[] marked;
    public Queue<Integer> pre;
    public Queue<Integer> post;
    public Stack<Integer> reversePost;

    public DepthFirstOrder(DirectedGraph graph){
        marked = new boolean[graph.V()];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
//        graph.show();
        for(int v = 0; v < graph.V(); v++) if(!marked[v]) dfsOrder(graph,v);
    }

    // put the order inside of pre, post and reversePost
    public void dfsOrder(DirectedGraph graph, int node){
        // add node visited at pre
        pre.add(node);
        marked[node] = true;
//        System.out.println("size tr = " + graph.adj[0].size());
        for(int neigh: graph.adj[node]){
//            System.out.println( "neigh = "+ neigh);
            if(!marked[neigh]) dfsOrder(graph,neigh);
        }
        // after done all the visit neigh then add the node
        // to the post -> node with least indegree will be at the end of queue
        post.add(node);
        // node with no indegree will be at beginning of stack
        reversePost.push(node);
    }

    public Iterable<Integer> pre(){ return pre;}
    public Iterable<Integer> post(){return post;}
    public Iterable<Integer> reversePost(){return reversePost;}

    public static void main(String[] args){
        DirectedGraph graph = new DirectedGraph(13);
        graph.addEdge(0,5);
        graph.addEdge(0,1);
        graph.addEdge(0,6);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(4,5);
        graph.addEdge(5,4);
        graph.addEdge(6,9);
        graph.addEdge(6,4);
        graph.addEdge(7,6);
        graph.addEdge(8,7);
        graph.addEdge(9,11);
        graph.addEdge(9,10);
        graph.addEdge(9,12);
        graph.addEdge(11,12);
        graph.show();
        DepthFirstOrder dfOrder = new DepthFirstOrder(graph);
        DirectedCycle directedCycle = new DirectedCycle(graph);
        System.out.println("The reverse Postorder is: ");
        for(int node: dfOrder.reversePost()) System.out.print(node +",");
        System.out.println();
        System.out.println("Is there a cycle in the graph? "+ directedCycle.hasCycle());
    }
}
