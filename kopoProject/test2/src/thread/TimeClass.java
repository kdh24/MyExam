package thread;

public class TimeClass implements Runnable{
	Thread t;

	@Override
	public void run() {
		while(true){
			try {
				System.out.println("반복되는 Time 스레드");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public TimeClass() {
	}
	
	public TimeClass(String str) {
		t = new Thread(this, str);
		t.start();
		System.out.println(t.getName());
	}

}
