package ch.hsr.intTe.domain;

import java.io.Serializable;

public class Comment implements Serializable{
	private static final long serialVersionUID = -4272793839234627484L;
	
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
}
