package function;

public class myPow {

    public static double myPow(double x, int n) {
        //base case
        if(x == 0.0){
            return 0.;
        }else if(x == 1.0){
            return 1.;
        }

        if( n == 0){
            return 1.;
        }else if(n == 1){
            return x;
        }else if(n == -1) {
            return 1/x;
        }

        //inductive case
        if(n%2 != 0){//odd
            // Integer.signum(n)) give out the sign of n
            return myPow(x, n/2) * myPow(x, (n/2) + Integer.signum(n));
        }else{
            double halfPow = myPow(x, n/2);
            return halfPow*halfPow;
        }
    }

    public static void main(String[] args){
        System.out.println(myPow(2.3,100));
    }
}
