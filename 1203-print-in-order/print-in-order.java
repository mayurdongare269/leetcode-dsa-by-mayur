class Foo { //../

    private CountDownLatch latch1;
    private CountDownLatch latch2;

    public Foo() {
        latch1 = new CountDownLatch(1); // wait for first() to finish
        latch2 = new CountDownLatch(1); // wait for second() to finish
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        latch1.countDown(); // release second()
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        latch1.await();     // wait for first()
        printSecond.run();
        latch2.countDown(); // release third()
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
         latch2.await();     // wait for second()
        printThird.run();
    }
}