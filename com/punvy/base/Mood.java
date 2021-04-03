package com.punvy.base;

public enum Mood {
	LONGING,
    GLOOM,
    APATHY;

	public Mood valueOf(String stringValue){
		if(stringValue.equalsIgnoreCase("LONGING")){
			return Mood.LONGING;
		}
		else if(stringValue.equalsIgnoreCase("GLOOM")){
			return Mood.GLOOM;
		}
		else if(stringValue.equalsIgnoreCase("APATHY")){
			return Mood.APATHY;
		}
		return null;
	}

	private Mood() {
		
	}
}
