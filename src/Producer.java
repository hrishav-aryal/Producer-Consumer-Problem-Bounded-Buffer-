
public class Producer implements Runnable{

	private BufferArray buffer;
	private int k, t;
	
	
	public Producer(BufferArray b, int seed_burst_length, int seed_sleep_time) {
		buffer = b;
		k = seed_burst_length;
		t = seed_sleep_time;
	}
	
	
	public void run(){
		
		int next_in = 0;
		while(true) {
			
			int k1 = RandomNumber.randomInteger(k);
			
			for(int i=0; i<k1; i++) {
				int index = (next_in+i) % buffer.getBufferLength();
				buffer.setBufferElement(index, buffer.getBufferElement(index)+1);
			}
			
			displayInfo(k1, next_in);
			
			next_in = (next_in + k1) % buffer.getBufferLength();
			
			int t1 = RandomNumber.randomInteger(t);
			SleepUtil.sleep(t1);
		}
		
	}
	
	
	public void displayInfo(int slots, int position) {
		
		System.out.println("Buffer Array after producer added 1 to '"+ slots +"' slot/s starting at position '"+ position +"': ");
		for(int j=0; j<buffer.getBufferLength() ;j++) {
			System.out.print(buffer.getBufferElement(j));
		}
		System.out.println("\n---------------------------------------------------\n");
		
	}
	
}
