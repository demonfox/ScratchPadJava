import java.util.concurrent.Semaphore;

class MyThread1 extends Thread {
    Semaphore sem1;
    Semaphore sem2;
    int start;
    int upper;
    public MyThread1(Semaphore sem1, Semaphore sem2, int s, int u)  {
        this.sem1 = sem1;
        this.sem2 = sem2;
        start = s;
        upper = u;
    } 
  
    @Override
    public void run() { 
        try { 
            // acquiring the lock
            while (start < upper) {
                sem1.acquire();
                System.out.println(start);
                start += 2;
                sem2.release();
            }
        } catch (InterruptedException exc) { 
                System.out.println(exc); 
        }
    }
}

class MyThread2 extends Thread {
    Semaphore sem1;
    Semaphore sem2;
    int start;
    int upper;
    public MyThread2(Semaphore sem1, Semaphore sem2, int s, int u)  {
        this.sem1 = sem1;
        this.sem2 = sem2;
        start = s;
        upper = u;
    } 
  
    @Override
    public void run() { 
        try { 
            // acquiring the lock
            while (start < upper) {
                sem1.acquire();
                System.out.println(start);
                start += 2;
                sem2.release();
            }
        } catch (Exception exc) { 
                System.out.println(exc); 
        }
    }
}
  
public class TwoThreadPrint {
    private int count = 0;
    private final Object lock = new Object();

    class Printer implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ": " + count++);
                    lock.notifyAll();
                    try {
                        if (count <= 100) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void print() {
        new Thread(new Printer(), "Odd").start();
        new Thread(new Printer(), "Even").start();
    }

    public static void main(String args[]) throws InterruptedException { 
        //Semaphore sem1 = new Semaphore(1);
        //Semaphore sem2 = new Semaphore(1);

        //MyThread1 mt1 = new MyThread1(sem1, sem2, 1, 20);
        //MyThread2 mt2 = new MyThread2(sem2, sem1, 2, 20);
        TwoThreadPrint t = new TwoThreadPrint();
        t.print();            
    } 
}
