package com.app.model.entity;

public class Data {

	public Timezone timezone;

	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Timezone getTimezone() {
		return timezone;
	}

	public void setTimezone(Timezone timezone) {
		this.timezone = timezone;
	}

	@Override
	public String toString() {
		return "Data [timezone=" + timezone + "]";
	}

}
