
public class Consumer implements Runnable{

	private BufferArray buffer;
	private int k, t;
	
	
	public Consumer(BufferArray b, int seed_burst_length, int seed_sleep_time) {
		buffer = b;
		k = seed_burst_length;
		t = seed_sleep_time;
	}
	
	
	public void run(){
		int next_out = 0;
		
		while(true) {
				
			int t2 = RandomNumber.randomInteger(t);
			SleepUtil.sleep(t2);
				
			int k2 = RandomNumber.randomInteger(k);
				
			for(int i=0; i<k2; i++) {
				int index = (next_out+i) % buffer.getBufferLength();
				int data = buffer.getBufferElement(index);
					
				if(data > 1) {
					System.out.println("Race condition occurred.");
				}
				
				buffer.setBufferElement(index, 0);
			}
			
			displayInfo(k2, next_out);
				
			next_out = (next_out + k2) % buffer.getBufferLength();
		}
			
	}
	
	public void displayInfo(int slots, int position) {
		
		System.out.println("Buffer Array after consumer resets '"+ slots +"' slot/s to 0 starting at position '"+ position +"': ");
		for(int j=0; j<buffer.getBufferLength() ;j++) {
			System.out.print(buffer.getBufferElement(j));
		}
		System.out.println("\n---------------------------------------------------\n");
		
	}
	
	
}
