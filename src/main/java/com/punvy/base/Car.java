package com.punvy.base;

public class Car {
	private boolean cool;

	@Override
	public String toString() {
		return "Car{" +
				"cool=" + cool +
				'}';
	}

	public Car(Boolean cool) {
		this.cool = cool;
	}
}
