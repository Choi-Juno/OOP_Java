package week7.Zombie;

import java.io.*;
import java.util.HashMap;

public class Game {
    private static void saveGame(File file, Hero hero, HashMap<String, Zombie> zombies) {
        try (BufferedWriter fw = new BufferedWriter(new FileWriter(file))) {
            fw.write("Hero " + hero.name + " " + hero.pos + " " + hero.hp + "\n");
            for (Zombie z : zombies.values()) {
                fw.write(z.name + " " + z.name + " " + z.pos + "\n");
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public static void main(String[] args) {
        Hero hero = new Hero("Hero", 1, 3);
        HashMap<String, Zombie> zombies = new HashMap<>();

        BufferedReader br = null;
        File file = new File("./week7/Zombie/zombie.txt");

        try {
            if (file.exists()) {
                br = new BufferedReader(new FileReader(file));
                while (true) { 
                    String line = br.readLine();
                    if (line != null) {
                        String data[] = line.split(" ");

                        if(data[0].equals("Hero")) {
                            hero = new Hero(data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                        }else {
                            zombies.put(data[0], new Zombie(data[1], Integer.parseInt(data[2])));
                        }
                    }else{
                        break;
                    }
                }
            }
            if (br != null) br.close();
        } catch (IOException e) {
            e.getStackTrace();
        }

        if (!file.exists() || zombies.isEmpty()) {
            zombies.put("Zombie1", new Zombie("Zombie1", 10));
            zombies.put("Zombie2", new Zombie("Zombie2", 20));
        }

        while (true) {
            hero.move();
            for (Zombie zombie : zombies.values()) {
                zombie.move();
            }

            for (Zombie zombie : zombies.values()) {
                System.out.println(zombie.name + " 현재 위치는 " + zombie.pos + "입니다.");
            }

            int heroPos = hero.pos;
            if (zombies.values().stream().anyMatch(zombie -> zombie.pos == heroPos)) {
                hero.hp--;
                saveGame(file, hero, zombies);
                if (hero.hp <= 0) {
                    System.out.println(hero.name + "이(가) 죽었습니다.");
                    break;
                }

                System.out.println("좀비에게 잡혔습니다.");
                continue;
            }

            saveGame(file, hero, zombies);
            if (hero.pos == hero.maxPos) {
                System.out.println("미션 클리어!!! 목적지에 도착했습니다.");
                return;
            }
        }
    }
}
