import java.util.Random;

class BankAccount {
	int balance = 0;	//금액

	public synchronized void withdraw(int money) {
		if (money > 0 && balance >= money) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
			balance -= money;

			System.out.printf("%d 인출하여 현재잔고 %d입니다. %n", money, balance);
		} else if (balance < money)
			System.out.println("잔고가 부족하여 인출할 수 없습니다.");
	}

	public synchronized void deposit(int money) {
		if (money > 0) {
			balance += money;
			System.out.printf("%d 입금하여 현재잔고 %d입니다. %n", money, balance);
		}
	}
}

public class SyncTest implements Runnable {
	BankAccount act = new BankAccount();

	@Override
	public void run() {
		while (true) {
			int amount = new Random().nextInt(10000);
			amount = amount%10 * 1000;
			System.out.printf("[%s] 금액=%d %n", Thread.currentThread().getName(), amount);
			act.deposit(amount);
			act.withdraw(amount*2);
			if (act.balance < 0) {
				System.out.printf("[%s] ", Thread.currentThread().getName());
				System.out.println("잔고: " + act.balance + " => 오류 종료");
				return;
			}
		}
	}
	
	public static void main(String[] args){
		Runnable r = new SyncTest();
		new Thread(r).start();
		new Thread(r).start();
	}
}
