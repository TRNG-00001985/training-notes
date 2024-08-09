
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    private final Queue<Integer> queue = new LinkedList<>();
    private final int MAX_CAPACITY = 5;

    public static void main(String[] args) {
        ProducerConsumerExample example = new ProducerConsumerExample();

        Thread producerThread = new Thread(example.new Producer());
        Thread consumerThread = new Thread(example.new Consumer());

        producerThread.start();
        consumerThread.start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            int value = 0;
            while (true) {
                synchronized (queue) {
                    while (queue.size() == MAX_CAPACITY) {
                        try {
                            queue.wait(); // Wait until there is space in the queue
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("Produced: " + value);
                    queue.offer(value++);
                    queue.notifyAll(); // Notify consumers that there is something to consume
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait(); // Wait until there is something to consume
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    int value = queue.poll();
                    System.out.println("Consumed: " + value);
                    queue.notifyAll(); // Notify producers that there is space in the queue
                }
            }
        }
    }
}
