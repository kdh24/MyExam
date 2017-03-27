package thread;

public class ThreadClass implements Runnable{//extends Thread{
	public void run() {
		for(int i=0; i<100; i++){
			System.out.println(i);
		}
	}
	
//	public static void main(String[] args){
//		ThreadClass r1 = new ThreadClass();
//		
//		r1.start();
//	}
}
