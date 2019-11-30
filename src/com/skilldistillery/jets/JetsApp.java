package com.skilldistillery.jets;

import java.util.List;
import java.util.Scanner;

public class JetsApp {
	public static Scanner kb = new Scanner(System.in); 
	private static AirField af = new AirField();

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
//		 app.printFleet(af.parseFile());
//		 app.fly(af.parseFile());
//		app.fastestJet(af.parseFile());
//		app.longestRange(af.parseFile());
// 		app.addJet(af.jets);
		app.removeJet(af.parseFile());
		
		
		
	}

	public void menu() {
		System.out.println("1: List fleet");
		System.out.println("2: Fly all jets");
		System.out.println("3: View fastest jet");
		System.out.println("4: View jet with longest range");
		System.out.println("5: Load all Cargo Jets");
		System.out.println("6: Dogfight!");
		System.out.println("7: Add a jet to Fleet");
		System.out.println("Remove a jet from Fleet");

	}

	public void printFleet(List<Jet> jetList) {
		for (Jet jet : jetList) {
			System.out.println(jet);

		}
		System.out.println();
	}

	public void fly(List<Jet> jetList) {
		for (Jet jet : jetList) {
			jet.fly();
		}
	}

	public void fastestJet(List<Jet> jetList) {
		Jet fastestJet = null;
		Double fastest = Double.MIN_VALUE;
		for (Jet jet : jetList) {
			if (jet.getSpeed() > fastest) {
				fastest = jet.getSpeed();
				fastestJet = jet;

			}

		}

		System.out.println(fastestJet.toString());
	}

	public void longestRange(List<Jet> jetList) {
		Jet longestRangeJet = null;
		Integer longestRange = Integer.MIN_VALUE;
		for (Jet jet : jetList) {
			if (jet.getRange() > longestRange) {
				longestRange = jet.getRange();
				longestRangeJet = jet;
			}
		}
		System.out.println(longestRangeJet.toString());
	}

	public void cargoCarrier(List<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}

	public void combatReady(List<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
	}
	
	public void addJet(List<Jet> jetList) {
		String model;
		double speed;
		int range;
		long price;
		Jet newJet = null;
		System.out.println("Add new Jet.\n 1: Fighter\n 2: Cargo\n 3: lmpl");
		model = kb.next();
		
		System.out.println("Add the speed of the jet (ex 122.45):");
		speed = kb.nextDouble();
		kb.nextLine();
		
		System.out.println("Add the range of the jet (ex 1000)");
		range = kb.nextInt();
		kb.nextLine();
		
		System.out.println("Add price of jet (ex 2990177)");
		price = kb.nextLong();
		
		if(model.equalsIgnoreCase("Fighter")) {
			newJet = new FighterJet(model, speed, range, price);
		}
		else if (model.equalsIgnoreCase("Cargo")) {
			newJet = new CargoPlane(model, speed, range, price);
		}
		else if (model.equalsIgnoreCase("lmpl")) {
			newJet = new Jetlmpl(model, speed, range, price);
		}
		
		af.jets.add(newJet);
	}
	
	public void removeJet(List<Jet> jetList) {
		int count = 1;
		int jetRemove;
		Jet jetRemoved = null;
		
		System.out.println("Select number to remove jet");
		for (Jet jet : jetList) {
			System.out.println(count + " " + "model: " +  jet.getModel());
			count++;
		}
			
		jetRemove = kb.nextInt();
		kb.nextLine();
		
		jetRemoved = af.jets.remove(jetRemove - 1);
		System.out.println(" Jet removed " + jetRemoved.getModel()) ;
		
		
	}
}
