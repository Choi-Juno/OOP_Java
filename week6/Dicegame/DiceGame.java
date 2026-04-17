public class DiceGame {
    public static void main(String[] args) {
        Thread first = new Dice("첫번째 주사위");
        Thread second = new Dice("두번째 주사위");

        System.out.println("주사위를 던졌습니다");

        first.start();
        second.start();
    }
}
