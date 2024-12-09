import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    
    private int n;
    
    private Semaphore zeroSemaphore = new Semaphore(1); // Allows zero() to start first
    private Semaphore oddSemaphore = new Semaphore(0);  // Ensures odd() waits initially
    private Semaphore evenSemaphore = new Semaphore(0); // Ensures even() waits initially

    public ZeroEvenOdd(int n) {
        this.n = n; // Number of pairs to print
    }

    // Method to print 0's
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            
            zeroSemaphore.acquire(); // Wait for permission to print 0
            printNumber.accept(0);   // Print 0
            
            // Alternate between odd and even semaphores
            if (i % 2 == 1) {
                oddSemaphore.release(); // Allow odd() to proceed
            } else {
                evenSemaphore.release(); // Allow even() to proceed
            }
        }
    }

    // Method to print odd numbers
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) { // Iterate over odd numbers
            oddSemaphore.acquire();      // Wait for permission to print an odd number
            printNumber.accept(i);       // Print the odd number
            zeroSemaphore.release();     // Signal zero() to print the next 0
        }
    }

    // Method to print even numbers
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) { // Iterate over even numbers
            evenSemaphore.acquire();     // Wait for permission to print an even number
            printNumber.accept(i);       // Print the even number
            zeroSemaphore.release();     // Signal zero() to print the next 0
        }
    }
}