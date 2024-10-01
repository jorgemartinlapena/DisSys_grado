package com.example;

public class Counter {

    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int getValue() {
        return c;
    }
}

class ThreadCounter implements Runnable {
	Counter c;
	int times;

	ThreadCounter(Counter c, int times)  {
		//1. Initialize the thread
		this.c = c;
		this.times = times;

	}

	@Override
	public void run() {
		for (int i = 1; i <= this.times; i++) {
			try {
				Thread.sleep(100); //wait 0,1 s
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			c.increment();
		}
	}


	public static void main(String[] args) throws Exception {

		int times = 10;

		//2. Create a counter object
			Counter counter = new Counter() ;

			//3. Create a thread1 that increment 10 times the counter
			ThreadCounter thCounter1 = new ThreadCounter (counter,times);
			Thread thread1 = new Thread(thCounter1);

			//4. start the counter thread
			thread1.start();

			//5. main waits for the counter thread to end.
			thread1.join();

			//6. main thread prints the final value of the counter
		System.out.println("Sum = " + counter.getValue());
	}
}
