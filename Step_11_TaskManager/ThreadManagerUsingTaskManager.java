package tech.codingclub.Step_11_TaskManager;

import java.util.Date;

public class ThreadManagerUsingTaskManager {
    public static void main(String[] args) {

        System.out.println("This side is Sneh Aashish Gupta");
        System.out.println("Running ThreadManager Example at " + new Date().getTime());

        TaskManager taskManager = new TaskManager(100);
        for (int i = 0; i < 10000; i++) {
            RunnableExample temp = new RunnableExample("THREAD-NO-"+i,0,500);
            taskManager.waitTillQueueIsFreeAndAddTask(temp);
            System.out.println("$$$$$$$"+i);
        }
        System.out.println("##############");
    }
}
