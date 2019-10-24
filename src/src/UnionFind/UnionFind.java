package UnionFind;

public class UnionFind {

    public  int[] id;
    public  int size;

    public UnionFind(int N){
        id = new int[N];
         // set all the node in the id array to the have root as itself
        for(int i = 0; i < N; i++) id[i] = i;
        size = N;
    }

    /***
     * follow the node id[p] which contains root of p until find the root of root of p
     * @param p
     * @return
     */
    public int findRoot(int p){
        while(p != id[p]) p = id[p];
        return p;
    }

    /***
     * uninon p and q to have the same root
     * @param p
     * @param root
     */
    public void connected(int p, int root){
        // find root of p
        int rootP = findRoot(p);
        // find root of root
        int rootRoot = findRoot(root);
        // if rootP is the root of root then no need to link
        if (rootP == rootRoot) return;
        // set root of p to the root of root
        id[p] = rootRoot;

        // find all node have p as root and change them to net root of p
        for(int i = 0; i < id.length; i++){
            if(id[i] == rootP) id[i] = rootRoot;
        }
    }

    public boolean isConnected(int p, int q){return findRoot(p) == findRoot(q);}

    public void show(){
        for(int i = 0; i < id.length;i++) System.out.print(id[i] + " ");
    }

    public static void main(String[] args){
        UnionFind uf = new UnionFind(9);
        uf.connected(4,3);
        uf.connected(3,8);
        uf.show();
    }
}
