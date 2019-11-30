package com.skilldistillery.jets;

public class Jetlmpl extends Jet {
	
	@Override
	public void fly() {
		super.fly();
		System.out.println("Model " + this.getModel() + " is in the air flying and has " + this.getRange()
		+ " hours of flight time left");
	}

	public Jetlmpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Jetlmpl(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}
}
