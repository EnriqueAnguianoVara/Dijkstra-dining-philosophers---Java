package paquete;

import java.util.concurrent.Semaphore;

record Fork(Semaphore fork_semaphore) {
	/**
	 * @return true -> Philosopher takes Fork , false -> Fork already assign to a Philosopher 
	 */
	boolean acquire() { return fork_semaphore.tryAcquire(); }
	void realase() { fork_semaphore.release(); }
	
}