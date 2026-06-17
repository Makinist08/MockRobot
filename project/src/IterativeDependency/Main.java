package IterativeDependency;

import IterativeDependency.dependencies.motor.Motor;
import IterativeDependency.window.Window;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Window window = new Window();
        int i = 0;
        Motor myMotor = null;
        Motor anotherMotor = null;

        while (window.isEnabled()) {

            window.update(window.getGraphics());

            Thread.sleep(500);
            if (i > 2 && myMotor == null) {
                myMotor = new Motor();
                anotherMotor = new Motor();
            }
            i++;

            if(myMotor != null){
                myMotor.setSpeed(i);
            }
            
            if(anotherMotor != null){
                anotherMotor.setSpeed(Math.pow(i, 2));
            }

            System.out.println(i);
        }
    }
}
