package 이승윤30219;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.xml.soap.Text;

public class Main {

	public static void main(String[] args) {
		try {
			File f = new File("C:/test/30219_이승윤.txt");
			if(f.exists() == false){
				System.out.println("파일이 존재하지 않아 새로 생성합니다. 파일명 : 30219_이승윤.txt");
				f.createNewFile();
			}
		} catch (Exception e) {
		}
		
		System.out.println("=========도서관리프로그램=========");
		
		menuprint();
		choice();
		
	}
	
	public static void menuprint(){
		System.out.println("1.도서추가");
		System.out.println("2.도서폐기");
		System.out.println("3.도서검색");
		System.out.println("4.신규등록도서");
		System.out.println("5.도서전체보기");
		System.out.println("0.종료");
	}
	
	public static void choice(){
		
		while(true){
			
			System.out.print("\n메뉴를 선택하세요 : ");
			
			int choice = inputchoice();
			
			switch(choice){
			
			case 1:
				add();
				break;
			case 2:
				delete();
				break;
			case 3:
				search();
				break;
			case 4:
				newbook();
				break;
			case 5:
				list();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}
	public static void add(){
		System.out.println("도서추가========================");
		
		System.out.println("데이터 입력");

		String[] data = {"도서명 : ", "저자 : ", "출판사 : "};
		
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i]);
			data[i] = inputstr();
		}
		
		Book b = new Book();
		b.setter(data);
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/test/30219_이승윤.txt", true));
			
			bw.write(b.data);
			bw.newLine();
			
			System.out.println("정상적으로 등록되었습니다.");
			System.out.println("=============================");
			
			bw.close();
			
		} catch (Exception e) {
		}
	}
	public static void delete(){
		System.out.println("도서폐기========================");
		
		Book b = new Book();
		
		if(b.output.length == 0){
			System.out.println("도서가 없습니다.");
			return;
		}
		
		for(int i = 0; i < b.output.length; i++){
			System.out.print("(" + (i+1) + ")");
			for(int j = 0; j < b.output[0].length; j++){
				System.out.print(b.output[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.print("폐기할 도서의 번호를 선택해주세요. : ");
		
		while(true){
			int choice = inputchoice();
			
			if(choice == 0 || choice > b.output.length){
				System.out.println("잘못된 번호 선택입니다.");
				System.out.println("=============================");
				return;
			}else{
				try {
					
					File file = new File("c:/test/30219_이승윤.txt");
					file.delete();
					file.createNewFile();
					
					BufferedWriter bw = new BufferedWriter(new FileWriter("c:/test/30219_이승윤.txt", true));
					
					for(int i = 0; i < b.output.length; i++){
						if(i == choice-1){
							continue;
						}
						for(int j = 0; j < b.output[0].length; j++){
							bw.write(b.output[i][j] + "\t");
						}
						bw.newLine();
					}
					
					bw.close();
					
					String[] get = b.getter(choice-1);
					System.out.print("(" + choice + ")");
					for(int i = 0; i < get.length; i++){
						System.out.print(get[i] + "\t");
					}
					System.out.println("도서가 삭제되었습니다.");
					System.out.println("=============================");
					return;
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
	}

	public static void search(){

		Book b = new Book();
		
		System.out.println("도서검색========================");

		if(b.output.length == 0){
			System.out.println("도서가 없습니다.");
			return;
		}
		
		String[] cho = {"책이름","저자","키워드"};
		
		System.out.println("상세 검색 메뉴를 선택하여 주십시오.");
		System.out.print("1.책이름 2.저자 3.통합 : ");
		
		int choice = inputchoice();
		
		System.out.print("검색할 " + cho[choice-1] + "을(를) 입력해주세요. : ");
		
		String str = inputstr(); 
		
		if(choice != 3 ){
			for(int i = 0; i < b.output.length; i++){
				if(b.output[i][choice-1].equals(str)){
					System.out.print("(" + (i+1) + ")");
					for(int j = 0; j < b.output[0].length; j++){
						System.out.print(b.output[i][j] + "\t");
						if(j==0 && b.output[i][0].length() < 8){
							System.out.print("\t");
						}
						if(j==1 && b.output[i][1].length() < 4){
							System.out.print("\t");
						}
						if(j==2 && b.output[i][2].length() < 4){
							System.out.print("\t");
						}
					}
					System.out.println();
				}
			}
			
		}else{
			for(int i = 0; i < b.output.length; i++){
				for(int j = 0; j < b.output[0].length; j++){
					if(b.output[i][j].equals(str)){
						System.out.print("(" + (i+1) + ")");
						for(int y = 0; y < b.output[0].length; y++){
							System.out.print(b.output[i][y] + "\t");
							if(j==0 && b.output[i][0].length() < 8){
								System.out.print("\t");
							}
							if(j==1 && b.output[i][1].length() < 4){
								System.out.print("\t");
							}
							if(j==2 && b.output[i][2].length() < 4){
								System.out.print("\t");
							}
						}
						System.out.println();
					}
				}
			}
		}
		
		System.out.println("=============================");
		
	}

	public static void newbook(){

		Book b = new Book();
		
		System.out.println("신규등록도서====================");

		if(b.output.length == 0){
			System.out.println("도서가 없습니다.");
			return;
		}
		
		for(int i = 0; i < b.output.length; i++){
			if(b.output[i][3].equals(b.format.format(b.date))){
				System.out.print("(" + (i+1) + ")");
				for(int j = 0; j < b.output[0].length; j++){
					System.out.print(b.output[i][j] + "\t");
					if(j==0 && b.output[i][0].length() < 8){
						System.out.print("\t");
					}
					if(j==1 && b.output[i][1].length() < 4){
						System.out.print("\t");
					}
					if(j==2 && b.output[i][2].length() < 4){
						System.out.print("\t");
					}
				}
				System.out.println();
			}
		}
		System.out.println("=============================");
	}
	
	public static void list(){
		Book b = new Book();
		System.out.println("전체도서목록==============================================================================");
		System.out.println("\t도서명\t\t\t저자\t\t\t출판사\t\t\t날짜");
		System.out.println("=======================================================================================");
		
		for(int i = 0; i < b.output.length; i++){
			for(int j = 0; j < b.output[0].length; j++){
				System.out.print(b.output[i][j] + "\t\t");
				if(j==0 && b.output[i][0].length() < 8){
					System.out.print("\t");
				}
				if(j==1 && b.output[i][1].length() < 4){
					System.out.print("\t");
				}
				if(j==2 && b.output[i][2].length() < 4){
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}
	
	public static int inputchoice(){

		Scanner scan = new Scanner(System.in);
		
		int choice = -1;
		
		while(choice == -1){
			try {
				choice = scan.nextInt();
			} catch (Exception e) {
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.print("다시 입력해주세요 : ");
				choice = -1;
			}
			String str = scan.nextLine();
		}
		
		return choice;
		
	}

	public static String inputstr(){

		Scanner scan = new Scanner(System.in);

		String str = scan.nextLine();
		
		return str;
		
	}
}
