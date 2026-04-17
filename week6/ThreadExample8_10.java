public class ThreadExample8_10 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        // 기능 구현
        for(int i = 1; i < 10; i++)
            System.out.println(getName() + " : " + i);
    }
}