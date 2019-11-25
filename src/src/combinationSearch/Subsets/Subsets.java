package combinationSearch.Subsets;

// using the binary 1 or 0 to represent the
public class Subsets {

    public static void subset(int num){
        int[] data = new int[num];
        subset(data,0);
    }

    public static void subset(int[] data, int start){
        if(start == data.length){
            System.out.print("[");
            for(int i = 0; i < data.length; i++){
                if(data[i] == 1) System.out.print(i+" ");
            }
            System.out.println("]");
            return;
        }
        data[start] = 0;
        subset(data,start + 1);
        data[start] = 1;
        subset(data,start + 1);
    }

    public static void main(String[] args){
        subset(4);
    }
}
