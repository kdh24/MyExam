package thread;

public class MainClass {

	public static void main(String[] args) throws Exception {
		ThreadClass r1 = new ThreadClass();
		
		Thread tc = new Thread(new ThreadClass());
//		tc.start();
//		while(true) {
//			Thread.sleep(500);
//			System.out.println("HAHAHAHA");
//		}

		Thread t = new Thread(new TimeClass("1번"));
		
		Thread a1 = new Thread(new Alarm(10000));
		Thread a2 = new Thread(new Alarm(5000));
		
		a1.start();
		a2.start();
		
//		r1.start();
	}

}
