public class SimpleLivelockExample {

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> attemptToLock(lock1, lock2));
        Thread thread2 = new Thread(() -> attemptToLock(lock2, lock1));

        thread1.start();
        thread2.start();
    }

    private static void attemptToLock(Object firstLock, Object secondLock) {
        while (true) {
            synchronized (firstLock) {
                System.out.println(Thread.currentThread().getName() + " acquired " + firstLock);

                try {
                    Thread.sleep(50); // Simulate doing some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                // Attempt to acquire the second lock
                synchronized (secondLock) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + secondLock);
                    // Both locks acquired; proceed with work
                    System.out.println(Thread.currentThread().getName() + " completed work");
                    return;
                }
            }
        }
    }
}
