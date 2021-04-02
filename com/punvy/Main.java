package com.punvy;

import java.util.ArrayDeque;
import java.util.Scanner;

import com.punvy.command.Command;
import com.punvy.command.CommandManager;
import com.punvy.base.HumanBeing;
import com.punvy.command.Creater;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayDeque<HumanBeing> List = new ArrayDeque<HumanBeing>();
		CommandManager cmdManager = new CommandManager();

		while(true) {
//			System.out.print("Введите команду: ");
//			String command = scanner.nextLine();
//			cmdManager.executeCommand(command);
			new Creater().createHumanBeing();
		}
	}
}
