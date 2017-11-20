package homework.epam.mod1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 */
public class SingleTonMyTest {
	public static int countOfSinglTons = 0;
	/**
	 *
	 */
	private static volatile SingleTonMyTest instanseOfSingleTon;
	
	/**
	 *
	 */
	private SingleTonMyTest() {
		countOfSinglTons++;
		System.out.println("Num OF SinglTons : " + countOfSinglTons);
	}
	
	public static void main(String[] args) {
		ExecutorService my1000ThreadPool = Executors.newFixedThreadPool(1000);
		for (int i = 0; i < 1000; i++) {
			final int finalI = i;
			my1000ThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("Num OF THREAD in pool " + finalI + " Start");
					SingleTonMyTest.getInstanseOfSingleTon();
					System.out.println("Num OF THREAD in pool " + finalI + " Stop");
				}
			});
		}
		my1000ThreadPool.shutdownNow();
	}

	/**
	 * @return
	 */
	public static SingleTonMyTest getInstanseOfSingleTon() {
		if (instanseOfSingleTon == null) {
			synchronized (SingleTonMyTest.class) {
				if (instanseOfSingleTon == null) {
					instanseOfSingleTon = new SingleTonMyTest();
				}
			}
		}
		return instanseOfSingleTon;
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	/**
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	/**
	 * @return
	 */
	@Override
	public String toString() {
		return super.toString();
	}
}