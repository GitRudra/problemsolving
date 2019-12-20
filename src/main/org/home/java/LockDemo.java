package org.home.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo implements Runnable{
    private Resource resource;
    private Lock lock;

    public LockDemo(Resource resource) {
        this.resource = resource;
        this.lock = new ReentrantLock();
    }

    @Override
    public void run() {
        try{
            if(lock.tryLock()){
                resource.doExecute();
            }else{
                resource.doPrint();;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}

class Resource{
    public void doExecute(){
        System.out.println("Executing some task !!!");
    }

    public void doPrint(){
        System.out.println("Printing some task !!!");
    }
}
