package week3;

import java.util.Scanner;

public class assign3_2 {
    private static void playerMove(int[] playerPos, String command, int[][] map) {
        int dx = 0;
        int dy = 0;
        switch (command) {
            case "w":
                dx = -1;
                break;
            case "a":
                dy = -1;
                break;
            case "s":
                dx = 1;
                break;
            case "d":
                dy = 1;
                break;
            default:
                System.out.println("Invalid command");
                return;
        }

        int nextX = playerPos[0] + dx;
        int nextY = playerPos[1] + dy;

        // 1) 맵 경계 체크
        if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) {
            System.out.println("맵 밖으로 나갈 수 없습니다.");
            return;
        }

        // 2) 벽 체크
        if (map[nextX][nextY] == 1) {
            System.out.println("벽에 부딛혔습니다.");
            return;
        }

        // 3) 이동
        playerPos[0] = nextX;
        playerPos[1] = nextY;
    }

    private static void printMap(int[][] map, int[] playerPos) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (i == playerPos[0] && j == playerPos[1]) {
                    System.out.print("P ");
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 0: 빈 칸, 1: 벽
        int map[][] = {
                { 0, 0, 1, 1, 1 },
                { 1, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 1 },
                { 1, 1, 1, 0, 1 },
                { 1, 1, 1, 0, 0 } };
        // (X, Y)
        int playerPos[] = { 0, 0 };
        int times = 0;

        while (true) {
            System.out.print("Enter a command (w, a, s, d): ");
            String command = sc.nextLine();
            playerMove(playerPos, command, map);
            printMap(map, playerPos);

            times++;
            if (playerPos[0] == 4 && playerPos[1] == 4) {
                System.out.println("You win!, " + times + "번 만에 도착했습니다.");
                break;
            }

        }
        sc.close();
    }
}
