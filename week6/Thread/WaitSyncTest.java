import java.util.Random;

class WaitBankAccount {
	int balance = 0;
	int diff = 0;

	public synchronized void withdraw(int money) {
		if (money < 0) {
			System.out.println("인출 금액이 잘못됐습니다.");
			return;
		}
		int count = 0;
		while (balance < money) {
			System.out.printf("[%s] ", Thread.currentThread().getName());
			// 지속적으로 잔금이 부족하여 메소드 종료
			if (++count > 3) {
				System.out.println("잔액이 부족하여 출금처리 못하고 종료합니다.");
				return;
			}

			System.out.printf("%16s", "wait(1000) 호출: ");
			System.out.printf("인출요구금액=%6d, balance=%6d %n", money, balance);
			try {
				wait();
				//wait(1000);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		System.out.printf("[%s] ", Thread.currentThread().getName());
		balance -= money;
		System.out.printf(" %12s 정상인출금액=%6d, balance=%6d %n", "정상 출금처리:",
				money, balance);
	}

	public synchronized void deposit(int money) {
		if (money < 0) {
			System.out.println("입금 금액이 잘못됐습니다.");
			return;
		}
		balance += money;
		System.out.printf("[%s] ", Thread.currentThread().getName());
		System.out.printf("%16s", "notify() 호출: ");
		System.out.printf("계좌입금금액=%6d, balance=%6d %n", money, balance);

		 notify();
		//notifyAll();
	}
}

public class WaitSyncTest implements Runnable {
	WaitBankAccount act = new WaitBankAccount();

	public void run() {
		for (int i = 1; i < 3; i++) {
			int amount = (int) (new Random().nextDouble() * 5 + 1) * 10000;
			act.deposit(amount);
			amount = (int) (new Random().nextDouble() * 5 + 1) * 10000;
			act.withdraw(amount);
		}
	}

	public static void main(String[] args) {
		Runnable r = new WaitSyncTest();
		new Thread(r).start();
		new Thread(r).start();
	}
}