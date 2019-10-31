package Graph.EdgeWeightDigraph;

public class DirectedEdge {
    public int node1;
    public int node2;
    public double weight;


    public DirectedEdge(int node1,int node2, double weight){
      this.node1=node1;
      this.node2=node2;
      this.weight=weight;
    }
    public int from(){return node1;}
    public int to(){return node2;}
    public void showFull(){  System.out.println("[" + node1 + "," + node2 + ","+ weight + "]");}


}
