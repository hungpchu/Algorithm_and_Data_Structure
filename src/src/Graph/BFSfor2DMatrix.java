package Graph;

import java.util.*;

public class BFSfor2DMatrix {
    // using hashSet to check for visited node
    HashSet<Integer> hs ;
    // using hashMap for no need to declare number of node before hand
    HashMap<Integer,Integer> hm ;

    public BFSfor2DMatrix(int[][] a, int source, int destination){
        hs = new HashSet<>();
        hm = new HashMap<>();
        // run BFS to find the shortest path
        BFS(a,source, destination);
    }
    // using queue like usual
    public void BFS(int[][] a, int source, int destination) {
        hs.add(source);
        Queue<Integer> queue = new LinkedList<>();
        int column = a[0].length;
        queue.add(source);
        while (!queue.isEmpty()) {
            source = queue.remove();
            if(source == destination && hs.contains(destination)) return;
            for (int j = 0; j < column; j++) {
                if (a[source][j] == 1 && !hs.contains(j)) {
                    hs.add(j);
                    hm.put(j, source);
                    queue.add(j);
                }
            }
        }
    }

    public Iterable<Integer> shortestPath(int source, int destination){
        if(hm.get(destination) == null) return null;
        List<Integer> list = new ArrayList<>();
        // back track from the destination to the source
        int path = hm.get(destination);
        // add the path to the list
        list.add(0,path);
        // from destination to souce, add all the vertex in between
    while(path != source) {
            path = hm.get(path);
            list.add(0, path);
        }
    // finally add the destination at the end
    list.add(destination);
        return list;
    }

    public void showPath(Iterable<Integer> path){
        if(path == null) {
            System.out.println("There is no path");
            return;
        }
        System.out.print("The path is : ");
        for(int pa: path) System.out.print(pa + " ");

    }


    public static void main(String[] args) {
        int[][] a = {{0, 1, 1, 0, 0, 1}, {1, 0, 0, 0, 0, 1}, {1, 0, 0, 1, 1, 0}, {0, 0, 1, 0, 1, 1}, {0, 0, 1, 1, 0, 0}, {0, 0, 0, 1, 0, 0}};
        int source = 0;
        int destination = 2;
        BFSfor2DMatrix bfs = new BFSfor2DMatrix(a, source, destination);
        bfs.showPath(bfs.shortestPath(source, destination));
    }
}

