package DynamicProgramming;


/***
 * Time:O(N^2)
 * Space:O(N^2)
 * find the number of way we can partition a set of n element
 * count the rhyme schemes
 * Formula: Bell(n) = Σ(k = 1 -> n) Subset(n,k);
 * Bell(3) = Bell(3,1)  + Bell (3,2) + Bell(3,3) = 1 + 3 + 1 =5
 * Bell triangle
 *      0  1   2    3   4
 *   0  0
 *   1  0  1
 *   2  0  1   2
 *   3  0  2   3   5
 *   4  0  5  10  15  20
 */
public class bellNumber {

    public static int bellNumber(int N){
        int[][] bell = new int[N + 1][N + 1];
        // init
        bell[1][1] = 1;

        for(int i = 2; i <bell.length; i++){
            for(int j = 0; j < bell.length; j++){
                if(j == 1) bell[i][j] = bell[i-1][i-1];
                else if( j > 0) bell[i][j] = bell[i][j-1] + bell[i-1][j-1];
            }
        }
        return bell[N][N];
    }

    public static void main(String[] args){
        int N = 6;
        System.out.println("Bell(" + N + ") is " + bellNumber(N));
    }
}
