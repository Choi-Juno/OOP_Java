
import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PhoneBook {
    public static void main(String[] args) {
        Vector<Person> phonebookList = new Vector<>();
        Scanner sc = new Scanner(System.in);
        BufferedWriter fw = null;
        BufferedReader br = null;;
        File f = new File("./phonebook.txt");

        try {
            // 파일이 있으면 데이터 읽기
            if(f.exists()) {
                br = new BufferedReader(new FileReader(f));

                while (true) {
                    String line = br.readLine();
                    if (line != null) {
                        String data[] = line.split(" ");
                        phonebookList.add(new Person(data[0], data[1], data[2]));
                    }
                    else break;
                }
                br.close();
            }

            while (true) { 
                System.out.println("1. 입력 2. 삭제 3. 검색 4. 전체 출력 5. 저장 6. 종료");
                int input = sc.nextInt();
                sc.nextLine(); // 버퍼에 남은 \n 소비

                if(input == 1) {
                    System.out.println("이름, 전화번호, 이메일을 입력하세요.");
                    String personInfo = sc.nextLine();

                    String data[] = personInfo.split(" ");

                    Person person = new Person(data[0], data[1], data[2]);
                    phonebookList.add(person);
                    System.out.println("입력되었습니다.");
                }
                else if(input == 2) {
                    System.out.println("삭제할 사람의 이름을 입력하세요");
                    String name = sc.nextLine();

                    for(int i = 0; i < phonebookList.size(); i++) {
                        if(phonebookList.get(i).name.equals(name)) {
                            phonebookList.remove(i);
                        }
                    }
                }
                else if(input == 3) {
                    System.out.println("검색할 사람의 이름을 입력하세요");
                    String name = sc.nextLine();

                    for(int i = 0; i < phonebookList.size(); i++) {
                        if(phonebookList.get(i).name.equals(name)) {
                            System.out.println(phonebookList.get(i).name + " " + phonebookList.get(i).phoneNumber + " " + phonebookList.get(i).email);
                        }
                        else {
                            System.out.println(name + " 이름의 사람이 없습니다.");
                        }
                    }
                }
                else if(input == 4) {
                    for(int i = 0; i < phonebookList.size(); i++) {
                        System.out.println(phonebookList.get(i).name + " " + phonebookList.get(i).phoneNumber + " " + phonebookList.get(i).email);
                    }
                }
                else if(input == 5) {
                    try {
                        fw = new BufferedWriter(new FileWriter(f));
                        for(int i = 0; i < phonebookList.size(); i++) {
                            fw.write(phonebookList.get(i).name + " " + phonebookList.get(i).phoneNumber + " " + phonebookList.get(i).email);
                            fw.write("\n");
                        }
                        fw.close();
                        System.out.println("저장되었습니다.");
                    } catch (IOException e) {
                        System.out.println("파일 저장 오류");
                    }
                }
                else if(input == 6) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                }
                else {
                    System.out.println("잘못된 입력입니다.");
                }
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류");
        }
        sc.close();
    }
}
