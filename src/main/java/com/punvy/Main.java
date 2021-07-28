package com.punvy;

import com.punvy.inter.CLI;
import com.punvy.inter.UI;


public class Main {
	public static void main(String[] args) {
		UI ui = new CLI();
		ui.run();
	}
}