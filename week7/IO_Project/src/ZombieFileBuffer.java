import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class ZombieFileBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int zom1 = 7;
		int zom2 = 15;
		int me = 1;
		
		File file = new File("c:\\temp\\zombie.sav");
		
        try {
        	if(file.exists()){ // 파일이 있으면
	        }
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            	 String line;
                 while ((line = br.readLine()) != null) {
                     System.out.println(line);
                     String pos[] = line.split(" ");
                    
                     me = Integer.parseInt(pos[0]);
                     zom1 = Integer.parseInt(pos[0]);
                     zom2 = Integer.parseInt(pos[0]);
                     System.out.println("저장된 파일 있음 이어서 게임 " + me + "," + zom1 + "," + zom2);
                 }
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		while(true) {
			System.out.println("왼쪽(1), 오른쪽(2), 점프(3), 종료(4)을 입력하세요.");
			int my = s.nextInt();
			
			if(my==1) {
				me= me-1;
				if(me <= 0) {
					System.out.println("맵 밖으로 나갈 수 없습니다.");
					me = 1;
				}
			}
			else if(my==2) {
				me = me+1;
			}
			else if(my==3) {
				int ran = r.nextInt(3)+1;
				me = me+ran;
			}
			else if(my==4) {
				file = new File("c:\\temp\\zombie.sav");
				
		        try {
		        	if(!file.exists()){ // 파일이 존재하지 않으면
			            file.createNewFile(); // 신규생성
			        }
		            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
		                String line = me + " " + zom1 + " " + zom2 +"\n";
		                bw.write(line);
		                bw.close();
		            }
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				
				break;
			}
			
			int zomm1 = r.nextInt(3)-1;
			zom1 = zom1 + zomm1;
			
			int zomm2 = r.nextInt(3)-1;
			zom2 = zom2 + zomm2;
			
			System.out.println("현재 내 위치 : "+me+", 좀비1의 위치 : "+zom1+" 좀비2의 위치 : "+zom2);
			
			if(zom1==me || zom2 == me) {
				System.out.println("좀비에게 잡혔습니다. 처음 위치에서 다시 시작합니다.");
				me = 1;
				zom1 = 7;
				zom2 = 15;
			}
			if(me >= 20) {
				System.out.println("미션 클리어!!! 목적지에 도착하였습니다.");
				break;
			}
			
		}
	}

}
