package OperatingSystem;

public class Synchronize extends Thread {
    private  String name;
    private  SynchronizeObject object;

    public Synchronize(SynchronizeObject obj, String n){
        this.name = n;
        this.object = obj;
    }

    public void run(){
        object.foo(name);
    }

    public static void main(String[] args){
        // different reference
        SynchronizeObject obj1 = new SynchronizeObject();
        SynchronizeObject obj2 = new SynchronizeObject();

        Synchronize thread1 = new Synchronize(obj1,"1");
        Synchronize thread2 = new Synchronize(obj2,"2");

        thread1.start();
        thread2.start();

        // same reference

//        SynchronizeObject obj = new SynchronizeObject();
//
//        Synchronize thread1 = new Synchronize(obj,"1");
//        Synchronize thread2 = new Synchronize(obj,"2");
//
//        thread1.start();
//        thread2.start();

    }


}
