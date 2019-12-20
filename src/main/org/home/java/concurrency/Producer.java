package org.home.java.concurrency;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        super();
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++){
            System.out.println("Produced item "+ i);
            try {
                queue.put("item "+ i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
