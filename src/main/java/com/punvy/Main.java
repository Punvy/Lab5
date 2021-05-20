package com.punvy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.punvy.base.HumanBeing;
import com.punvy.command.HumanBeingBuilder;
import com.punvy.inter.AbstractUI;
import com.punvy.inter.CLI;
import com.punvy.inter.UI;
import com.punvy.logic.JsonManager;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		AbstractUI ui = new CLI();
		ui.run();

	}
}