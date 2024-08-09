public class SimpleDeadLock{

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " acquired " + lock1);
                try {
                    Thread.sleep(50); // Simulate doing some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + lock2);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " acquired " + lock2);
                try {
                    Thread.sleep(50); // Simulate doing some work
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + " acquired " + lock1);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
