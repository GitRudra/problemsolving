package org.home.design.chainresponsibity;

public abstract class AbstractNumberProcessor {

    protected AbstractNumberProcessor nextProcessor;
    abstract void processNumber(Number request);
    public AbstractNumberProcessor setNextProcessor(AbstractNumberProcessor nextProcessor){
        this.nextProcessor = nextProcessor;
        return this.nextProcessor;
    }

    public void doProcess(Number x){

    }
}
