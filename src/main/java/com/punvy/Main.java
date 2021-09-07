package com.punvy;

import com.punvy.inter.CLI;
import com.punvy.inter.UI;

import java.util.Map;


public class Main {
	public static void main(String[] args) {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n",
					envName,
					env.get(envName));
		}
		UI ui = new CLI();
		ui.run();
	}
}