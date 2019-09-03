package by.htp.task.WorkWithFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.Scanner;


	public class WorkWithFile {

	    private String path;
	    private RandomAccessFile file;
	    
	    public WorkWithFile(String path) {
	        this.path = path;
	    }
    
	    public static boolean isWord(String str) {	
			  return str.matches("[a-zA-Z]+"); 
		}
    
	    public static boolean isEmail(String str) {
			return str.matches(".+\\@.+\\.(.+)"); 
		}
	    
	    public static boolean isPhone(String str)
		{
			return str.matches("\\+?([3][7][5])\\d{9}"); 
		}
	    
	    //������ ����� �����
	    public String read() throws IOException {
	        file = new RandomAccessFile(path, "r");
	        String res = "";
	        int b = file.read();
	        while(b != -1){
	            res = res + (char)b;
	            b = file.read();
	        }
	        
	        file.close();
	        return res;
	        
	    }


	    // ������ � ���� (+ ������ � ����� �����)
	    public void addInToFile(String st) throws IOException {
	    	long l;
	    	
	    	file = new RandomAccessFile(path, "rw");
	        
		
	    	l = file.length();
	    	file.seek(l);
		 
	        
	        file.write(st.getBytes("UTF-8"));
	        file.close();
	    }
	    
	    
	    //���������� ���������� ��� ������� ����
	    public void addInfo() throws IOException {
	    	Scanner scan = new Scanner(System.in);
	    	
	    	
    		System.out.print("������� ���: ");
    		String text = scan.nextLine();
    		
    		while(isWord(text) == false) {
    			System.out.println("�������� ������!!!");
    			System.out.print("������� ���: ");
    			text = scan.nextLine();
    		}
			
			addInToFile(text + " ");

			
    		System.out.print("������� �������: ");
    		String text1 = scan.nextLine();
    		
    		while(isWord(text1) == false) {
    			System.out.println("�������� ������!!!");
    			System.out.print("������� �������: ");
    			text1 = scan.nextLine();
    		}
    		
    		addInToFile(text1 + " ");

    		
    		for(int r = 0; r < 3; r++) {
    			
    			System.out.print("������� ����: ");
    			String text2 = scan.nextLine();

    			if(r == 0) {
        				while(isWord(text2) == false) {
	    	           		System.out.println("�������� ������!!!");
	    	           		System.out.print("������� ����: ");
	    	           		text2 = scan.nextLine();
    				}
    			}
    			
    			while(text2.equals("") == false & isWord(text2) == false) {
    				System.out.println("�������� ������!!!");
	           		System.out.print("������� ����: ");
	           		text2 = scan.nextLine();
    			}
				
				addInToFile(text2 + " ");
			}
				

    		for(int t = 0; t < 3; t++) {
    			System.out.print("������� ����� ��������: ");
    			String text3 = scan.nextLine();
    			
    			if(t == 0) {
    				while(isPhone(text3) == false) {
    	           		System.out.println("����� �������� ������ ���� � ������� +375 (XX) XXXXXXX!!!");
    	           		System.out.print("������� ����� ��������: ");
    	           		text3 = scan.nextLine();
					}	
    					
    			}else {
    				while(text3.equals("") == false & isPhone(text3) == false) {
    					System.out.println("����� �������� ������ ���� � ������� +375 (XX) XXXXXXX!!!");
    	           		System.out.print("������� ����� ��������: ");
    	           		text3 = scan.nextLine();
    				}	
    			}
    			
    			addInToFile(text3 + " ");
    		}
    		
    		
    		System.out.print("������� Email: ");
    		String text4 = scan.nextLine();
    		while(isEmail(text4) == false) {
    			System.out.println("�������� ������, Email, ������ ���� � ������� xxxx@xxxx.xx");
    			System.out.print("������� Email: ");
    			text4 = scan.nextLine();
    		}
    		
    		addInToFile(text4 + " \n");
	    }	
	    
		
		//�������� ������ �� �����
	    public void delete() throws IOException {
	    	
	    	File sourceFile = new File("testfile.txt");
	    	File outputFile = new File("test.txt");
	    	String line;

	    	BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
	    	BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
	    	
	    	Scanner scn = new Scanner(System.in);
	    	System.out.println("������� ����� ������, ������� ������ �������: ");
	    	Long lineToDelete = scn.nextLong();
	    	
	    	for (int i = 1; (line = reader.readLine()) != null; i++) {
	    		if (i != lineToDelete) {
	    			writer.write(line, 0, line.length());
	    			writer.newLine();	    	
	    		}
	    	}
	    	
	    	reader.close();
	    	writer.close();
	    	sourceFile.delete();
	    	outputFile.renameTo(sourceFile);
	  }
	    
	    
	  //�������������� ������ � �����
	  public void edit() throws IOException{
	      	
		  File sourceFile = new File("testfile.txt");
		  File outputFile = new File("test.txt");
		  String line;

		  BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
		  BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
	    	
		  Scanner sc = new Scanner(System.in);
		  System.out.println("������� ����� ������, ������� ������ �������������: ");
		  int lineToEdit = sc.nextInt();
	    	
		  for (int i = 1; (line = reader.readLine()) != null; i++) {
	    	if (i != lineToEdit) {
	    		writer.write(line, 0, line.length());
    			writer.newLine();		    	
	    	}else {
	    		Scanner scan = new Scanner(System.in);
	    		
	    		System.out.print("������� ���: ");
	    		String text = scan.nextLine();
	    		
	    		while(isWord(text) == false | text.equals("")) {
	    			System.out.println("�������� ������!!!");
	    			System.out.print("������� ���: ");
	    			text = scan.nextLine();
	    		}
				
	    		writer.write(text + " ");

				
	    		System.out.print("������� �������: ");
	    		String text1 = scan.nextLine();
	    		
	    		while(isWord(text1) == false | text1.equals("")) {
	    			System.out.println("�������� ������!!!");
	    			System.out.print("������� �������: ");
	    			text1 = scan.nextLine();
	    		}
	    		
	    		writer.write(text1 + " ");

	    		
	    		for(int r = 0; r < 3; r++) {
	    			
	    			System.out.print("������� ����: ");
	    			String text2 = scan.nextLine();

	    			if(r == 0) {
	        				while(text2.equals("") | isWord(text2) == false) {
		    	           		System.out.println("�������� ������!!!");
		    	           		System.out.print("������� ����: ");
		    	           		text2 = scan.nextLine();
	    				}
	    			}
					while(text2.equals("") == false & isWord(text2) == false) {
		           		System.out.println("�������� ������!!!");
		           		System.out.print("������� ����: ");
		           		text2 = scan.nextLine();
					}
					
					writer.write(text2 + " ");
				}
					

	    		for(int t = 0; t < 3; t++) {
	    			System.out.print("������� ����� ��������: ");
	    			String text3 = scan.nextLine();
	    			
	    			if(t == 0) {
	    				while(isPhone(text3) == false) {
	    	           		System.out.println("����� �������� ������ ���� � ������� +375 (XX) XXXXXXX!!!");
	    	           		System.out.print("������� ����� ��������: ");
	    	           		text3 = scan.nextLine();
						}	
	    					
	    			}else {
	    				while(text3.equals("") == false & isPhone(text3) == false) {
	    					System.out.println("����� �������� ������ ���� � ������� +375 (XX) XXXXXXX!!!");
	    	           		System.out.print("������� ����� ��������: ");
	    	           		text3 = scan.nextLine();
	    				}	
	    			}
	    			
	    			writer.write(text3 + " ");
	    		}
	    		
	    		
	    		System.out.print("������� Email: ");
	    		String text4 = scan.nextLine();
	    		while(isEmail(text4) == false) {
	    			System.out.println("�������� ������, Email, ������ ���� � ������� xxxx@xxxx.xx");
	    			System.out.print("������� Email: ");
	    			text4 =scan.nextLine();
	    		}
	    		
	    		writer.write(text4 + " \n");
		    }
		}
		  
	    reader.close();
	   	writer.close();
	   	sourceFile.delete();
	   	outputFile.renameTo(sourceFile);
	   	

  }
}