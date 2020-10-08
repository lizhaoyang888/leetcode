package thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: lichaoyang
 * @Date: 2020-09-20 21:10
 */
public class ThreadDemo3 {

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
                        while (num >= 10) {
                            obj.wait();
                        }
                        num++;
                        System.out.println(num);
                        obj.notify();
                        Thread.sleep(100);
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
                        while (num <= 0) {
                            obj.wait();
                        }
                        num--;
                        System.out.println(num);
                        obj.notify();
                        Thread.sleep(100);
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
