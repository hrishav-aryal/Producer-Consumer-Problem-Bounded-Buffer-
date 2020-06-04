
public class BufferArray {
	
	private int[] buffer_array;
	
	public BufferArray(int n) {
		buffer_array = new int[n];
		initialize();
	}
	
	public void initialize() {
		for(int i=0; i<buffer_array.length; i++) {
			buffer_array[i] = 0;
		}
	}
	
	public void setBufferElement(int index, int element) {
		buffer_array[index] = element;
	}
	
	public int getBufferElement(int index) {
		return buffer_array[index];
	}
	
	public int getBufferLength() {
		return buffer_array.length;
	}

}
