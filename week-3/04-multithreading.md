# Lecture / Guided Coding Example

1. multithreading
   1. thread class
   2. runnable Interface
   3. states if a thread
   4. syncronization
   5. deadlock
   6. livelock
   7. Producer Consumer


---


# Multi Threadinng

**Processes**
A process has a self-contained execution environment. A process generally has a complete, private set of basic run-time resources.

**Threads**

- Threads exist within a process
- every process has at least one. 
- Threads share the process's resources, including memory and open files
- JVM allows an application to have multiple threads of execution running concurrently.
- Every thread has a priority. The threads with higher priority have preference over threads with lower priority for execution.


**Deamon Threads:** Low priority threads that run in background.their role is to serve user threads. usefull for background tasks such as garbage collection, releasing memory of unused objects.

- When JVM starts, a single non deamon thread that calls the main method a the class and the JVM continues to execute threads until:
    - the exit method for Runtime is called
    - All the non deamon methods have died, either by returing someting or by throwing an execption.
- As a programmer , you can start one thread called the main thread. main thread has the ability to create additional threads.


There are two ways to create a thread of execution. 

1. extend Thread class
2. Implement runnable interface

### States of Thread

- New: Thread is created but has not yet started
- Runnable:  the thread might actually be running or waiting for the operating system to assign CPU time to it.
- Blocked:  A Blocked state will occur whenever a thread tries to acquire lock on object and some other thread is already holding the lock.
- Waiting: waiting indefinitely for another thread to perform a particular action
- Timed Waiting: waiting for another thread to perform an action or for a specified amount of time to pass
- Terminated: the thread has stopped running.

### Synchronization

A mechanism that ensures only one thread can access a shared resource at a time.

### Deadlock

Deadlock occurs when two or more threads are unable to proceed because each is waiting for a resource that the other thread holds, creating a circular dependency.

### Livelock

Livelock occurs when two or more threads continuously change their states in response to each other without making any progress. Unlike deadlock, where threads stop, in livelock, threads are active but stuck in a loop.

### Producer-Consumer

The producer-consumer problem is a classic synchronization problem that involves coordinating access to a shared resource (like a queue) between two types of threads: producers (which add items to the queue) and consumers (which remove items from the queue).

