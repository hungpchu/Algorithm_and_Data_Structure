package OperatingSystem;

public class SynchronizeObject {
    /***
     * synchronized to a method =  two threads cannot execute synchro­
     * nized methods on the same object instance at the same time.
     * @param name
     */
    public synchronized void foo(String name){
        try{
            System.out.println("Thread " + name + ".foo(): start");
            Thread.sleep(30);
            System.out.println("Thread " + name + ".foo(): end");
        }catch(InterruptedException exc){
            System.out.println("Thread " + name + " interrupted");
        }
    }
}
