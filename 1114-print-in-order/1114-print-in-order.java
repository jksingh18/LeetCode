import java.util.concurrent.CountDownLatch;

class Foo {
    
    private final CountDownLatch secondLatch = new CountDownLatch(1); // Ensures second() waits for first()
    private final CountDownLatch thirdLatch = new CountDownLatch(1);  // Ensures third() waits for second()

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        // Signal that first() has completed, allowing second() to proceed
        secondLatch.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // Wait until first() signals completion
        secondLatch.await();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        // Signal that second() has completed, allowing third() to proceed
        thirdLatch.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // Wait until second() signals completion
        thirdLatch.await();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}