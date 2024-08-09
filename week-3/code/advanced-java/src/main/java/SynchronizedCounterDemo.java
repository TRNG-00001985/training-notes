public class SynchronizedCounterDemo{

    private int counter = 0; // Shared resource

    // Method to increment the counter
    public synchronized void increment() {
        counter++;
    }

    // Method to get the current value of the counter
    public synchronized int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        SynchronizedCounterDemo example = new SynchronizedCounterDemo();

        // Create and start multiple threads that increment the counter
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Print the final value of the counter
        System.out.println("Final counter value: " + example.getCounter());
    }
}
