package org.home.design.command;

public class Light {
    private boolean switchStatus;

    public Light(boolean switchStatus) {
        this.switchStatus = switchStatus;
    }

    public void switchOn(){
        switchStatus = true;
    }

    public void switchOff(){
        switchStatus = false;
    }
}
