package DFS;

public class searchInGrid {

    public static int[][]  grid =
            {{1,0,1,1,1},
            {0,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,1,1},
            {0,0,1,0,0}};

    public static  boolean checkSearch(int rS,int cS, int rE, int cE){
        if(rS >= grid.length || rS < 0) return false;
        if(cS >= grid[0].length || cS < 0) return false;
        if(grid[rS][cS] == 1) return false;
        if(rS == rE && cE == cS) return true;
        int temp = grid[rS][cS];
        grid[rS][cS] = 1;
        boolean checkForward = checkSearch(rS,cS+1,rE,cE);
        boolean checkBackward = checkSearch(rS,cS-1,rE,cE);
        boolean checkUpward = checkSearch(rS - 1,cS,rE,cE);
        boolean checkDownward = checkSearch(rS + 1,cS,rE,cE);
        boolean checkDig1 = checkSearch(rS + 1,cS+1,rE,cE);
        boolean checkDig2 = checkSearch(rS - 1,cS+1,rE,cE);
        boolean checkDig3 = checkSearch(rS + 1,cS-1,rE,cE);
        boolean checkDig4 = checkSearch(rS - 1,cS-1,rE,cE);
        grid[rS][cS] = temp;

        return checkBackward || checkDownward || checkForward || checkUpward || checkDig1 || checkDig2 || checkDig3 || checkDig4;
    }

    public static void main(String[] args){
        System.out.println("check = "+ checkSearch(1,1,0,4));
    }
}
