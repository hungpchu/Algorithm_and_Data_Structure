package Graph.EdgeWeightDigraph;


import Graph.DepthFirstSearch;

import java.util.*;

// time:O(V+E)
public class DepthFirstOrder {

    public boolean[] marked;
    public Queue<Integer> pre;
    public Queue<Integer> post;
    public Stack<Integer> reversePost;

    public DepthFirstOrder(EdgeWeightDigraph graph){
        marked = new boolean[graph.V];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        graph.show();
        for(int v = 0; v < graph.V; v++) if(!marked[v]) dfsOrder(graph,v);
    }

    // put the order inside of pre, post and reversePost
    public void dfsOrder(EdgeWeightDigraph graph, int node){
        // add node visited at pre
        pre.add(node);
        marked[node] = true;
//        System.out.println("size tr = " + graph.adj[0].size());
        for(DirectedEdge edge: graph.adj[node]){
            int neigh = edge.to();
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
    public Iterable<Integer> reversePost(){
        List<Integer> reversePostList = new ArrayList<>();
        while(!reversePost.isEmpty()){
            int node = reversePost.pop();
            reversePostList.add(node);
        }
        return reversePostList;
    }

    public static void main(String[] args){
        EdgeWeightDigraph graph = new EdgeWeightDigraph(8);
        graph.addEdge(new DirectedEdge(5,4,0.35));
        graph.addEdge(new DirectedEdge(4,7,0.37));
        graph.addEdge(new DirectedEdge(5,7,0.28));
        graph.addEdge(new DirectedEdge(5,1,0.32));
        graph.addEdge(new DirectedEdge(4,0,0.38));
        graph.addEdge(new DirectedEdge(0,2,0.26));
        graph.addEdge(new DirectedEdge(3,7,0.39));
        graph.addEdge(new DirectedEdge(1,3,0.29));
        graph.addEdge(new DirectedEdge(7,2,0.34));
        graph.addEdge(new DirectedEdge(6,2,0.40));
        graph.addEdge(new DirectedEdge(3,6,0.52));
        graph.addEdge(new DirectedEdge(6,0,0.58));
        graph.addEdge(new DirectedEdge(6,4,0.493));
//        graph.show();
        DepthFirstOrder dfOrderDirected = new DepthFirstOrder(graph);
        System.out.println("The reverse Postorder is: ");
        for(int node: dfOrderDirected.reversePost()) System.out.print(node +",");
    }
}

