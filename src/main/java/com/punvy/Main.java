package com.punvy;

import com.punvy.base.HumanBeing;
import com.punvy.inter.AbstractUI;
import com.punvy.inter.CLI;

import java.lang.reflect.Field;

public class Main {
	public static void main(String[] args) {
		AbstractUI ui = new CLI();
		while(true) {
			for (Field field : HumanBeing.class.getDeclaredFields()) {
				ui.inputField(field);
			}
		}
	}
}
