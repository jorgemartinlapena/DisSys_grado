package com.example;
import java.util.Scanner;

public class SecondTimer implements Runnable {
    /*
    Write a run method that forever:
        - sleeps 1 second, 
        - wakes up, increments the number of seconds by one, prints it, and sleeps again 1 second
    */    

    private int seconds = 0;

    public void run() {

        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println("Seconds: " + seconds++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Seconds to wait");
        try (Scanner secin = new Scanner(System.in)) {
            int secondsToWait = secin.nextInt();

            SecondTimer timer = new SecondTimer();
            Thread timerThread = new Thread(timer);

            timerThread.start();

            try {
                Thread.sleep(secondsToWait * 1000);
                timerThread.interrupt();  //Stop the timer
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
    
    }
}



