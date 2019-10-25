package Graph.EdgeWeightDigraph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/***
 * Given a sets of jov with duration to be completed, with the precedence constraints
 * that certains job needed to be completed before certain job begin
 * -> how schedule on identical processors that they are all completed in the minimum amount of time
 */
public class CriticalPathMethod {

    public static void main(String[] args){
        int N = StdIn.readInt(); StdIn.readLine();
        EdgeWeightDigraph graph = new EdgeWeightDigraph(2*N+2);
        int start = 2*N, end  = 2*N+1;
        for(int v = 0; v < N; v++){
            String[] a = StdIn.readLine().split("\\s+");
            double duration = Double.parseDouble(a[0]);
            // add the start time node of the job to end time node of the job with the edge weight = duration to complete job
            graph.addEdge(new DirectedEdge(v,v+N,duration));
            // add edge from start node to the current node with edge weight = 0.0
            graph.addEdge(new DirectedEdge(start,v,0.0));
            // add edge from current node to end node with edge weight = 0.0
            graph.addEdge(new DirectedEdge(v+N,end,0.0));
            for(int j = 1; j < a.length; j++){
                int sucessor = Integer.parseInt(a[j]);
                // add the constraint from current job to after job with the edge weight = 0.0
                graph.addEdge(new DirectedEdge(v+N,sucessor,0.0));
            }
        }

        AcyclicLP longestPath = new AcyclicLP(graph, start);

        StdOut.print("Start time:\n");
        for(int v = 0; v < N;v++){
            StdOut.printf("%4d: %5.1f\n", v, longestPath.distTo[v+N]);
        }
        StdOut.printf("Finish time: %5.1f\n",longestPath.distTo[end]);

    }
}
