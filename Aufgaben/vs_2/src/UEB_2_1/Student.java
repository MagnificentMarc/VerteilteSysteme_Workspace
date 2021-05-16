package UEB_2_1;

import java.util.Random;

public class Student implements Runnable {
    private KitchenCounter theke;
    private String name;


    public Student(KitchenCounter theke, String nm) {
        this.theke = theke;
        this.name = nm;
    }

    @Override
    public void run() {
        while(true) {
            //up to 10 sec waitingTime.
            Random rnd = new Random();
            int zufallWartezeit = rnd.nextInt(3);
            //Sleep waitingTime, then generate new LeberkaasSemmel.
            try {
                Thread.sleep(zufallWartezeit*1000);
                this.theke.take();
            } catch (InterruptedException ire) {
                System.out.println("Interrupted Except. caught: " + ire);
                //further handling in real scenario.
            }
        }
    }
}
