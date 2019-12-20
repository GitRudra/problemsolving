package org.home.design.command;

public class Client {
    public static void main(String[] args) {
        RemoteControl control = new RemoteControl();
        Light light = new Light(false);
        LightOnCommand onCommand = new LightOnCommand(light);
        LightOffCommand offCommand = new LightOffCommand(light);
        control.setCommand(onCommand);
        control.pressButton();
        control.setCommand(offCommand);
        control.pressButton();
    }

}
