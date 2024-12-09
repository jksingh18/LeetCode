// 1. Semaphore provides a simple mechanism to enforce order between the two threads by allowing or blocking access based on permits.

// 2. fooSemaphore.acquire():Ensures foo() waits until it is allowed to print. Initially, fooSemaphore has 1 permit, so foo() can execute immediately.

// 3. barSemaphore.release():Signals the bar() method to proceed after foo() finishes printing.

// 4. barSemaphore.acquire():Ensures bar() waits for the signal from foo(). Initially, barSemaphore has 0 permits, so bar() cannot execute until foo() signals.

// 5. fooSemaphore.release():Signals the foo() method to proceed after bar() finishes printing.

import java.util.concurrent.Semaphore;

class FooBar {
    
    private int n;
    
    private Semaphore fooSemaphore = new Semaphore(1); // Controls access for `foo()`
    private Semaphore barSemaphore = new Semaphore(0); // Controls access for `bar()`


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            // Wait for permission to print "foo"
            fooSemaphore.acquire(); 
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            
            // Signal barSemaphore to allow "bar" to proceed
            barSemaphore.release(); 
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            // Wait for permission to print "bar"
            barSemaphore.acquire(); 
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            
            // Signal fooSemaphore to allow "foo" to proceed
            fooSemaphore.release(); 
        }
    }
}