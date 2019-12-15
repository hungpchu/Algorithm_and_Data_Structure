package OperatingSystem;

public class HelloThread extends Thread {

    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        HelloThread t = new HelloThread();
        t.start();
    }

}
