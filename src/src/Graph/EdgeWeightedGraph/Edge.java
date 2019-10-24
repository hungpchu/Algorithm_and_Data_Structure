package Graph.EdgeWeightedGraph;

public class Edge implements Comparable<Edge> {
    public int node1;
    public int node2;
    public double weight;

    public Edge(int node1,int node2,double weight){
        this.node1 = node1;
        this.node2= node2;
        this.weight = weight;
    }

    public double weight(){return weight;}
    public int node1(){return node1;}
    public int node2(){return node2;}

    public int other(int vertex){
        if(vertex == node1) return node2;
        else if (vertex == node2) return node1;
        return 0;
    }

    public int compareTo(Edge that){
        if(this.weight() > that.weight()) return +1;
        else if (this.weight() < that.weight()) return -1;
        else return 0;
    }

    public String toString(){ return String.format("Edge connect" + node1 + " to " + node2+ " with the weight = "+ weight);}

    public String show(){ return String.format("[" + other(node2) + ","+ weight + "]");}
    public String showFull(){ return String.format("[" + node1 + "," + node2 + ","+ weight + "]");}
}
