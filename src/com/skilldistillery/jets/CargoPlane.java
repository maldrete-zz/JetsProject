package com.skilldistillery.jets;

public class CargoPlane extends Jet implements CargoCarrier {

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void loadCargo() {
		System.out.println("All cargo loaded!");
	}
	
	@Override
	public void fly() {
		super.fly();
		System.out.println(this.getModel() + " is in the air flying and has a range of " + this.getRange());
	}
}
