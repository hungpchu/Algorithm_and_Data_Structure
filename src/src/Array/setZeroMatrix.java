package Array;

public class setZeroMatrix {
    public static void setZero(int[][] a){
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[0].length;j++){
                if(a[i][j] == 0){
                    a[i][0] = 0;
                    a[0][j] = 0;
                }
            }
        }
//        show(a);
        // set 0 for all row with entry value = 0
        for(int row = 0; row < a.length; row++) if(a[row][0] == 0) set0Row(a,row);

        // set 0 for all columns with entry val =0
        for(int col = 0; col < a[0].length; col++) if(a[0][col] == 0)set0Col(a,col);
    }
    public static void set0Col(int[][] a, int col){
        for(int i = 0; i < a.length; i++) a[i][col] = 0;
    }

    public static void set0Row(int[][] a, int row){
        for(int j = 0; j < a[0].length; j++) a[row][j] = 0;
    }

    public static void show(int[][] a){
        for(int i = 0; i < a.length;i++){
            for(int j = 0; j < a[0].length;j++) System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args){
        int[][] a = {{1,2,3,4},
                {5,6,0,7},
                {8,9,10,11},
                {12,0,13,14}};
        setZero(a);
        show(a);
    }
}
