class IncThread extends Thread {
	//?????? ????
	public IncThread(String name) {
		setName(name); //?????? ??? ????
	}
	
	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				sleep(50);
				System.out.print(getName() + ": " + i);
				System.out.println(", ?????? ?????? ??: " + activeCount());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class DecThread extends Thread {
	public void run() {
		for (int i = 5; i > 1; i--)
			try {
				sleep(50);
				System.out.print(getName() + ": " + i);
				System.out.println(", ?????? ?????? ??: " + activeCount());
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		IncThread inc = new IncThread("???? ??????");
		inc.start();
		DecThread dec = new DecThread();
		dec.start();		
		//System.out.println(", ?????? ?????? ??: " + Thread.activeCount());
	}
}
