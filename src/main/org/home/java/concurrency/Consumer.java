package org.home.java.concurrency;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        //for(int i=0;i<10000;i++){
        while(true){

            try {
               String consumed =  queue.take();
                System.out.println("Consumed "+ consumed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
