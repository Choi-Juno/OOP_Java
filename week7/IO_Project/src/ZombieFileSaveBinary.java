import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class ZombieFileSaveBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int zom1 = 7;
		int zom2 = 15;
		int me = 1;
		
		File file = new File("c:\\temp\\zombie.bin");
		
        try {
        	if(file.exists()){ // 파일이 있으면
        		byte b[] = new byte [3]; // 비어 있는 byte 배열
        		try {
        			FileInputStream fin = new FileInputStream("c:\\\\temp\\\\zombie.bin");
        			int n=0, c;
        			while((c = fin.read())!= -1) { // -1은 파일 끝(EOF)
        				b[n] = (byte)c; // 읽은 바이트를 배열에 저장
        				n++;
        			}
        			me = (int)b[0];		//파일에서 읽어온 값은 주인공의 위치에
        			zom1 = (int)b[1];	//좀비1의 위치에 설정
        			zom2 = (int)b[2];	//좀비2의 위치에 설정
        			
        			// 배열 b[]의 바이트 값을 모두 화면에 출력
        			System.out.println("저장된 세이브 파일이 있습니다. 이어서 게임을 진행합니다.");
        			System.out.println("주인공 위치: " + me + " 좀비1 위치: " + zom1 + " 좀비2 위치: " + zom2 + " 에서 시작합니다.");
        			fin.close();
        		} catch(IOException e) {
        			System.out.println("c:\\Temp\\test.out에서 읽지 못했습니다. 경로명을 체크해보세요");
        		}
        	}
        } catch (Exception e) {
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
								
				file = new File("c:\\temp\\zombie.bin");
				
		        try {
		        	if(!file.exists()){ // 파일이 존재하지 않으면
			            file.createNewFile(); // 신규생성
			        }
		        	FileOutputStream fout = new FileOutputStream("c:\\Temp\\zombie.bin");
		        	
		        	byte a = (byte)me;
		        	byte b = (byte)zom1;
		        	byte c = (byte)zom2;
		        	byte pos[] = { a, b, c };
		        	
					for(int i=0; i<pos.length; i++)
						fout.write(pos[i]); // 배열 b의 바이너리를 그대로 기록
					fout.close();

				} catch(IOException e) {
					System.out.println("c:\\Temp\\test.out에 저장할 수 없었습니다. 경로명을  확인해 주세요");
					return;
				}
				System.out.println("종료합니다. 게임을 c:\\Temp\\zombie.bin 세이브 파일을 저장했습니다.");

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
