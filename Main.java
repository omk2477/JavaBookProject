package �̽���30219;

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
			File f = new File("C:/test/30219_�̽���.txt");
			if(f.exists() == false){
				System.out.println("������ �������� �ʾ� ���� �����մϴ�. ���ϸ� : 30219_�̽���.txt");
				f.createNewFile();
			}
		} catch (Exception e) {
		}
		
		System.out.println("=========�����������α׷�=========");
		
		menuprint();
		choice();
		
	}
	
	public static void menuprint(){
		System.out.println("1.�����߰�");
		System.out.println("2.�������");
		System.out.println("3.�����˻�");
		System.out.println("4.�űԵ�ϵ���");
		System.out.println("5.������ü����");
		System.out.println("0.����");
	}
	
	public static void choice(){
		
		while(true){
			
			System.out.print("\n�޴��� �����ϼ��� : ");
			
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
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default:
				System.out.println("�������� �ʴ� �޴��Դϴ�.");
			}
		}
	}
	public static void add(){
		System.out.println("�����߰�========================");
		
		System.out.println("������ �Է�");

		String[] data = {"������ : ", "���� : ", "���ǻ� : "};
		
		for(int i = 0; i < data.length; i++){
			System.out.print(data[i]);
			data[i] = inputstr();
		}
		
		Book b = new Book();
		b.setter(data);
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("C:/test/30219_�̽���.txt", true));
			
			bw.write(b.data);
			bw.newLine();
			
			System.out.println("���������� ��ϵǾ����ϴ�.");
			System.out.println("=============================");
			
			bw.close();
			
		} catch (Exception e) {
		}
	}
	public static void delete(){
		System.out.println("�������========================");
		
		Book b = new Book();
		
		if(b.output.length == 0){
			System.out.println("������ �����ϴ�.");
			return;
		}
		
		for(int i = 0; i < b.output.length; i++){
			System.out.print("(" + (i+1) + ")");
			for(int j = 0; j < b.output[0].length; j++){
				System.out.print(b.output[i][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.print("����� ������ ��ȣ�� �������ּ���. : ");
		
		while(true){
			int choice = inputchoice();
			
			if(choice == 0 || choice > b.output.length){
				System.out.println("�߸��� ��ȣ �����Դϴ�.");
				System.out.println("=============================");
				return;
			}else{
				try {
					
					File file = new File("c:/test/30219_�̽���.txt");
					file.delete();
					file.createNewFile();
					
					BufferedWriter bw = new BufferedWriter(new FileWriter("c:/test/30219_�̽���.txt", true));
					
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
					System.out.println("������ �����Ǿ����ϴ�.");
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
		
		System.out.println("�����˻�========================");

		if(b.output.length == 0){
			System.out.println("������ �����ϴ�.");
			return;
		}
		
		String[] cho = {"å�̸�","����","Ű����"};
		
		System.out.println("�� �˻� �޴��� �����Ͽ� �ֽʽÿ�.");
		System.out.print("1.å�̸� 2.���� 3.���� : ");
		
		int choice = inputchoice();
		
		System.out.print("�˻��� " + cho[choice-1] + "��(��) �Է����ּ���. : ");
		
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
		
		System.out.println("�űԵ�ϵ���====================");

		if(b.output.length == 0){
			System.out.println("������ �����ϴ�.");
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
		System.out.println("��ü�������==============================================================================");
		System.out.println("\t������\t\t\t����\t\t\t���ǻ�\t\t\t��¥");
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
				System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
				System.out.print("�ٽ� �Է����ּ��� : ");
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
