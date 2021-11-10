package tech.codingclub.Step_11_TaskManager;

import java.util.Date;
import java.util.Scanner;

public class RunnableExample implements Runnable {

    private String threadName;
    private int counter;
    private int waitTimeWhileLoop;

    public RunnableExample(String threadName, int counter, int waitTimeWhileLoop) {
        this.threadName = threadName;
        this.counter = counter;
        this.waitTimeWhileLoop = waitTimeWhileLoop;
    }

    //We are overriding how run() will work :-
    public void run() {
        //What process is to run parallel is defined:-
        while (counter < 10000) {
            counter++;
            //sleep!
            try {
                Thread.sleep(waitTimeWhileLoop);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName + ":" + counter);
        }
    }

    public static void main(String[] args) {

        System.out.println("This side is Sneh Aashish Gupta");
        System.out.println("Running RunnableExampleExample at " + new Date().getTime());

        RunnableExample runnable1 = new RunnableExample("THREAD 1",0,500);
        RunnableExample runnable2 = new RunnableExample("THREAD 2",0,1000);
        RunnableExample runnable3 = new RunnableExample("THREAD 3", 0,2000);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);
        Thread thread3 = new Thread(runnable3);
        //'Thread' object is created using 'Runnable' class...

        thread1.start();
        thread2.start();
        thread3.start();

        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
    }
}
