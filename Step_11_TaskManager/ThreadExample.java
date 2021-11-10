package tech.codingclub.Step_11_TaskManager;

import java.util.Date;
import java.util.Scanner;

public class ThreadExample extends Thread {

    private String threadName;
    private int counter;
    private int waitTimeWhileLoop;

    public ThreadExample(String threadName, int counter, int waitTimeWhileLoop) {
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
            /*
            if (threadName.equals("THREAD 1")) {
                try {
                    Thread.sleep(500);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (threadName.equals("THREAD 2")) {
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (threadName.equals("THREAD 3")) {
                try {
                    Thread.sleep(2000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
             */
            System.out.println(threadName+":"+counter);
            /*
            interrupt() vs sleep() ?
             */
                /*
            To prevent use of multiple if-else to sleep the thread execution
            a constructor can be used, i.e. using another parameter say 'waitTimeWhileLoop'
             */
        }
    }

    public static void main(String[] args) {

        System.out.println("This side is Sneh Aashish Gupta");
        System.out.println("Running ThreadExample at " + new Date().getTime());

        ThreadExample thread1 = new ThreadExample("THREAD 1",0,500);
        ThreadExample thread2 = new ThreadExample("THREAD 2",0,1000);
        ThreadExample thread3 = new ThreadExample("THREAD 3", 0,2000);

        /*
        run() vs start()
        threadName.start() => Parallel Execution of Threads
        threadName.run() => Sequential Execution of Threads
         */
        thread1.start();
        System.out.println(thread1.counter);
        thread2.start();
        System.out.println(thread2.counter);
        thread3.start();
        System.out.println(thread3.counter);
        /*
            -> When start() isn't executed:-
           0
          500
          500
        * This is because three different objects of Thread class have been created with
            initial counter values as assigned by user.
        *
            -> When start() is executed
          1000  |  0
          1000  |  500
          1000  |  1000
          MINE  |  When putting print statement after each thread call
          -------------
          1000  |  1000
           500  |  1000
           500  |   500
          Rishabh Sir's
        * This is happening as execution is parallel so if first thread is implemented till '10879' then thread 2 has more
            time to be executed till '100000' and thread 3 is executed from start and ends at '500'

        */

        /*
        Working of threads:-
        In the main() function the Main thread is created and within it three child threads (thread1, thread2 and thread3)
        are spawned and since they were running in between the main() function execution ended that's why the execution of thread
        wasn't completed and was non-uniform as it was interrupted.

        This can be prevented by using 'Scanner'
         */
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
    }
}
