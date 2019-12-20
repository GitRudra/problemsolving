package org.home.java;

public class DemonThreadDemo extends Thread {
    public static void main(String[] args) {
        System.out.println("Entered Main Method");
        DemonThreadDemo demo = new DemonThreadDemo();
        demo.setDaemon(false);
        demo.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException x) {
        }

        System.out.println("Main Method Exit");
    }

    public void run() {
        System.out.println("run Method Entry");

        try {
            System.out.println("In run Method: currentThread() is"
                    + Thread.currentThread());

            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException x) {
                }

                System.out.println("In run method.." + Thread.currentThread());
            }
        } finally {
            System.out.println("run Method Exit");
        }
    }
}
