
import java.lang.Thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * Performance issues with concurrency
 * This shares many of the same concurrency issues as the c++ version
 * In this program, the Thread.join() calls are blocking.
 * In this case, it's not really a problem, but if it were perfoming -
 * more complex operations, then it could severely hold up the -
 * performance of the program.
 * 
 * Vulnerabilities exhibited with use of strings
 * Strings in Java are much safer than character array's in C++
 * but still have their issues. The most notable one that I've
 * personally come across is since String is a class, a String
 * can be null, which can cause unforseen errors when trying to 
 * check or compare Strings. Java strings are much more resistant to 
 * buffer overflows or String formatting attacks, but can still be 
 * exploited in database injection attacks.
 * 
 * Security of the data types exhibited.
 * Just like the C++, I'm just using int's here, so pretty safe -
 * for the most part. 
 * 
 * However, I would really be careful about using a `static`
 * class variable like I did here. They're prone to making hard to 
 * diagnose errors if they're forgotten about.
 * 
 */

public class ThreadCounter extends Thread {

	private ThreadType type;
	private Lock lock;
	public static int counter = 0;
	
	public ThreadCounter(ThreadType type, Lock lock) {
		this.type = type;
		this.lock = lock;
	}

	public void run() {
		if (type != null) {
			switch (type) {
			case COUNT_UP:
				this.countUp();
				break;
			case COUNT_DOWN:
				this.countDown();
				break;
			default:
				System.out.println("Error: type of thread is invalid.");
				break;
			}
		}
	}
	
	@SuppressWarnings("static-access")
	private void countUp() {
		this.lock.lock();
		for (int i = 0; i < 20; i++) {
			this.counter++;
			System.out.println("countUp: counter = " + this.counter);
		}
		this.lock.unlock();
	}
	
	@SuppressWarnings("static-access")
	private void countDown() {
		this.lock.lock();
		for (int i = 0; i < 20; i++) {
			this.counter--;
			System.out.println("countDown: counter = " + this.counter);
		}
		this.lock.unlock();
	}
	
	public static void main(String args[]) {
		Lock lock = new ReentrantLock();
		ThreadCounter t1 = new ThreadCounter(ThreadType.COUNT_UP, lock);
		ThreadCounter t2 = new ThreadCounter(ThreadType.COUNT_DOWN, lock);
		
		/*
		 * due to the nature of threads and mutexes, this 
		 * can SOMETIMES count DOWN before counting UP
		 */
		
		try {
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
