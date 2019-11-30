package com.skilldistillery.jets;

public class FighterJet extends Jet implements CombatReady {
	
	

	@Override
	public void fight() {
		System.out.println("Guns up!");
		System.out.println("All systems ready to fight");		
	}

	public FighterJet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		super.fly();
		System.out.println("Model " + this.getModel() + " is in the air flying and has a range of " + this.getRange());
	}
	
	

}
