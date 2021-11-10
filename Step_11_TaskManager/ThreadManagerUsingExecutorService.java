package tech.codingclub.Step_11_TaskManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManagerUsingExecutorService {
    private int poolSize;
    private ExecutorService executorService;

    public ThreadManagerUsingExecutorService(int poolSize) {
        this.poolSize = poolSize; //Self:- Why this reference used here?
        executorService = Executors.newFixedThreadPool(poolSize);
    }

    public void execute(Runnable runnable) {
        executorService.submit(runnable);
    }

    public static void main(String[] args) {
/*
        ExecutorService executorService = Executors.newFixedThreadPool(100);
  //
        RunnableExample runnableExample1 = new RunnableExample("THREAD 1", 0, 500);

        executorService.submit(runnableExample1);
        //How submit() works?
        executorService.submit(new RunnableExample("THREAD 2",0,1000));
        executorService.submit(new RunnableExample("THREAD 3",0,2000));
   //
        for (int i = 0; i < 1000; i++) {
            RunnableExample temp = new RunnableExample("THREAD "+i, 0 , 10);
            executorService.submit(temp); //No need of 'Scanner' when using ExecutorService
            //This is the case where queue is heavy -> pause within this loop...
        }
*/

        ThreadManagerUsingExecutorService threadManagerUsingExecutorService = new ThreadManagerUsingExecutorService(100);
        /*
        Requirements:-

        1. Task Manager for N number of threads parallely !
        2. Need to pause the Main Thread when the size of queue is enough..
         */
        for (int i = 0; i < 100000; i++) {
            RunnableExample temp = new RunnableExample("THREAD-No-"+i,0,100+i);
            threadManagerUsingExecutorService.execute(temp);
        }
        System.out.println("##############"); //This got printed and after that also threads are adding/running this is undesirable
        //A TaskManager can resolve this issue...
    }
}
