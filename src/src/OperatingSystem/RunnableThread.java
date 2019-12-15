package OperatingSystem;

/***
 * Implements Runnable will let a class (superclass) extends the other class(subclass)
 */
public class RunnableThread implements Runnable{
    public int count = 0;
    public void run(){
        System.out.println("RunnableThread starts");
        try{
            while(count < 5){
                Thread.sleep(5);
                count++;
            }
        }catch(InterruptedException exc){
            System.out.println("Runnable Thread interrupt");
        }
        System.out.println("Runnable Thread terminate");
    }

    public static void main(String[] args){
        RunnableThread  instance = new RunnableThread();
        Thread thread = new Thread();
        thread.start();

        while(instance.count != 5){
            try{
                Thread.sleep(5);
               // instance.run();
            }catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }
}
