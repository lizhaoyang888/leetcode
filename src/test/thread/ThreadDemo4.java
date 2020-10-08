package thread;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-20 21:10
 */
public class ThreadDemo4 {

    private static volatile Integer num = 0;

    private static Object obj = new Object();


    static class Producer extends Thread{
        @Override
        public void run() {
            producer();
        }

        private void producer() {
            while (true) {
                synchronized (obj) {
                    try {
                        System.out.println("producer is sleep start");
                        Thread.sleep(1000);
                        System.out.println("producer is sleep finish");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    static class Consumer extends Thread{
        @Override
        public void run() {
            consumer();
        }

        private void consumer() {
            while (true) {
                synchronized (obj) {
                    try {
                        System.out.println("consumer is sleep start");
                        Thread.sleep(1000);
                        System.out.println("consumer is sleep finish");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Thread producer = new Producer();
        Thread consumer = new Consumer();
        producer.start();
        consumer.start();
    }
}
