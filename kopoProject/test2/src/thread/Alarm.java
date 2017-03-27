package thread;

public class Alarm implements Runnable{
	Thread t;
	int time;
	
	@Override
	public void run() {
		try {
			Thread.sleep(time);
			System.out.println("알람시간입니다.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Alarm(int time) {
		this.time = time;
	}
	
}
