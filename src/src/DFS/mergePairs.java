package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/***
 * There is series of integer pairs like (1,3),(7,10),(5,7),(4,1).
 * Create unique grouping if any value in pair matches with any value of other pairs. So for above example output become: (1,3,4) and (7,10,5).
 */
public class mergePairs {
    public static HashSet<Integer> marked = new HashSet<>();
    public static HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();


    public static List<List<Integer>> mergePair(List<int[]> pair){
        List<List<Integer>> res = new ArrayList<>();
        for(int[] a: pair){
            if(!hm.containsKey(a[0])){
                HashSet<Integer> newHs = new HashSet<>();
                newHs.add(a[1]);
                hm.put(a[0],newHs);
            }
            else {
                HashSet<Integer> updateList = hm.get(a[0]);
                updateList.add(a[1]);
                hm.put(a[0],updateList);
            }
            if(!hm.containsKey(a[1])){
                HashSet<Integer> newHs = new HashSet<>();
                newHs.add(a[0]);
                hm.put(a[1],newHs);
            }
            else {
                HashSet<Integer> updateList = hm.get(a[1]);
                updateList.add(a[0]);
                hm.put(a[1],updateList);
            }
        }

        for(int[] a:pair){
            List<Integer> newPair = new ArrayList<>();
            if(!marked.contains(a[0])) dfs(a[0],newPair);
            res.add(newPair);
            newPair = new ArrayList<>();
            if(!marked.contains(a[1])) dfs(a[1],newPair);
        }

        return res;
    }

    public static void dfs(int num, List<Integer> pair){
        marked.add(num);
        pair.add(num);
        for(int neigh: hm.get(num)){
            if(!marked.contains(neigh)) dfs(neigh,pair);
        }
    }

    public static void main(String[] args){
        List<int[] > pair = new ArrayList<>();
        int[] p1 = {1,3};
        pair.add(p1);
        int[] p2 = {7,10};
        pair.add(p2);
        int[] p3 = {5,7};
        pair.add(p3);
        int[] p4 = {4,1};
        pair.add(p4);

        for(List<Integer> list: mergePair(pair)){
            for(int n: list)System.out.print(n + " ");
            System.out.println();
        }
    }
}
