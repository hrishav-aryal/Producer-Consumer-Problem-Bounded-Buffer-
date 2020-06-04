// Race condition is observed after a reasonable amount of time with values n=50, k=18, and t=23.

public class Assignment2 {

	public static void main(String[] args) {
		
		if(args.length != 3) throw new IllegalArgumentException("Must pass exactly three arguments.");
		
		int n = Integer.parseInt(args[0]);
		int k = Integer.parseInt(args[1]);
		int t = Integer.parseInt(args[2]);
		
		BufferArray buffer = new BufferArray(n);
		
		Thread producer = new Thread(new Producer(buffer, k, t));
		Thread consumer = new Thread(new Consumer(buffer, k, t));
		
		producer.start();
		consumer.start();
		
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
