NOTES - Threads & Networking

Executor Service

It does away with the need of using one's own thread manager which can be plagued with bugs, hence it's useful to run
multiple threads at once.

This is implemented using 'FixedThreadPool'
    -> A thread pool is something in which every thread that is created is queued will be waiting for it to be executed
        based on CPU usage, Operating System spec., number of cores available in CPU, etc. is all considered in an optimised
        way by the Executor Service
