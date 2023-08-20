package paquete;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;


/**
 * @author enriq
 * Problema de la cena de los fil�sofos
 */
public class Principal {
	
	static List<Tenedor> phi = List.of(
			new Tenedor(new Semaphore(1)),
			new Tenedor(new Semaphore(1)),
			new Tenedor(new Semaphore(1)),
			new Tenedor(new Semaphore(1)),
			new Tenedor(new Semaphore(1))
			);
	
	/**
	 * @param args
	 * Podr�a haber utilizado el m�todo Thread (setName()) en vez de haber creado un atributo para la clase Philosopher
	 */
	public static void main(String[] args) {
		IntStream.range(0, phi.size()).forEach(index->{
			new Thread(new Filosofo(
					String.valueOf("Philosopher "+index),
					phi.get(index % phi.size()),
					phi.get((index+1) % phi.size())
			)).start();
		});
		
	}
	
}