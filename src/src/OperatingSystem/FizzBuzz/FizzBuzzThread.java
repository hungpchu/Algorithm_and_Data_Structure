package OperatingSystem.FizzBuzz;

public class FizzBuzzThread extends Thread{
    protected static int current = 1;
    private int max;
    private boolean div3,div5;
    private String toPrint;

    public FizzBuzzThread(boolean div3, boolean div5, int max, String toPrint){
        this.div3 = div3;
        this.div5 = div5;
        this.max = max;
        this.toPrint = toPrint;
    }

    public void print(){System.out.println(toPrint);}

    public synchronized void run(){
        while(true){
            if(current > max) return;
            if( div3 && div5){
                if(current % 3 == 0 && current % 5 == 0) {
                    print();
                    System.out.println(" current FizzBuzz = " + current);
                }
                current++;
            }else if( div3){
                if(current % 3 == 0){
                    print();
                    System.out.println("current Fizz = "+ current);
                }

                current++;
            }else if( div5){
                if(current % 5 == 0){
                    print();
                    System.out.println("current Buzz = "+ current );
                }
                current++;
            }
        }
    }


}
