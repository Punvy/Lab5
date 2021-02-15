package com.punvy;

import java.util.ArrayDeque;
import java.util.Scanner;

import com.punvy.base.HumanBeing;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayDeque<HumanBeing> List = new ArrayDeque<HumanBeing>();
		
		
		while(true) {
			System.out.print("Введите команду: ");
			String command = scanner.nextLine();
			

			if(command.equalsIgnoreCase("exit")) {
				scanner.close();
				System.exit(0);
			}
		}
	}
}
