package com.jitin.springbootbatchexamplewithmysql.model;

public enum Division {
	HONOURS("Ist Div. with Honours"), FIRST("Ist Div."), SECOND("IInd Div."), THIRD("IIIrd Div.");
	private final String value;

	@Override
	public String toString() {
		return this.value;
	}

	Division(String v) {
		this.value = v;
	}
}
