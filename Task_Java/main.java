package by.htp.task.main;

import java.io.IOException;
import java.util.Scanner;

import by.htp.task.WorkWithFile.WorkWithFile;


public class main{

    private static WorkWithFile worker;

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        worker = new WorkWithFile("testfile.txt");
        Scanner sc = new Scanner(System.in);
        int a;
        
        System.out.println("Выберите действие: ");
        System.out.println("1.Добавить пользователя.");
        System.out.println("2.Редактировать пользователя.");
        System.out.println("3.Удалить пользователя.");
        System.out.println("4.Показать всех пользователей.");
        System.out.println("5.Выйти из программы.");
    
        while(sc.hasNextInt() == true) {
        	a = sc.nextInt();
        	if(a == 1) {
        		worker.addInfo();
        	}
        	
        	if(a == 2) {
        		worker.edit();
        	}
        	
        	if(a == 3) {
        		worker.delete();
        	}
        	
        	if(a == 4) {
        		System.out.println(worker.read());
        	}
        	
        	if(a == 5) {
        		System.exit(0);
        	}
        }
    }  
}


