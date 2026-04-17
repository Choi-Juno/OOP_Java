class IncThread extends Thread {

    public IncThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0; i < 5; i++) {
            try {
                sleep(50);
                System.out.print(getName() + ": " + i);
                System.out.println(", 활성화된 스레드 수: " + activeCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class DecThread extends Thread {
    public DecThread(String name) {
        super(name);
    }

    @Override
    public void run() {
            for(int i = 0; i < 5; i++) {
                try {
                    sleep(50);
                    System.out.print(getName() + ": " + i);
                    System.out.println(", 활성화된 스레드 수: " + activeCount());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


public class ThreadExample8_11 {
    public static void main(String[] args) {
        try {
            Thread.sleep(1000);
            System.out.println("main thread 실행");
            IncThread incThread = new IncThread("IncThread");
            incThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
            System.out.println("main thread 실행");
            DecThread decThread = new DecThread("DecThread");
            decThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
