package paquete;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;


/**
 * @author enriq
 * Dining philosophers problem
 */
public class Main {
	
	static List<Fork> phi = List.of(
			new Fork(new Semaphore(1)),
			new Fork(new Semaphore(1)),
			new Fork(new Semaphore(1)),
			new Fork(new Semaphore(1)),
			new Fork(new Semaphore(1))
			);
	
	/**
	 * @param args
	 * I could use here the Thread method setNmae() instead of creating an atribute for the Philosopher class
	 */
	public static void main(String[] args) {
		IntStream.range(0, phi.size()).forEach(index->{
			new Thread(new Philosopher(
					String.valueOf("Philosopher "+index),
					phi.get(index % phi.size()),
					phi.get((index+1) % phi.size())
			)).start();
		});
		
	}
	
}