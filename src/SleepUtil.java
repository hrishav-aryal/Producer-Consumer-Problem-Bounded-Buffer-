
public class SleepUtil {
	
	public static void sleep(int t) {
		try {
			Thread.sleep(t * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
	
}
