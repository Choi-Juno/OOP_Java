class MyThread implements Runnable {
	//스레드 기능을 구현하기 위한 메소드 재정의
	@Override
	public void run() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
		//기능 구현
		for (int i = 1; i < 10; i++)
			System.out.println(Thread.currentThread().getName() + ": " + i);
	}
}

public class SimpleThread {
	public static void main(String[] args) {
		Runnable r = new MyThread();
		Thread th = new Thread(r);
		th.start();
	}
}
