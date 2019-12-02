package com.skilldistillery.jets;

import java.util.List;
import java.util.Scanner;

public class JetsApp {
	public List<Jet> jets = af.parseFile();
	public static Scanner kb = new Scanner(System.in); 
	private static AirField af = new AirField();

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
//		app.printFleet(af.parseFile());
//		app.fly(af.parseFile());
//		app.fastestJet(af.parseFile());
//		app.longestRange(af.parseFile());
// 		app.addJet(af.jets);
//		app.removeJet(af.parseFile());
		app.run();
		
		
		
	}
	
	public void run() {
		int choice;
		
		do {
			menu();
			choice = kb.nextInt();
			
		switch(choice) {
			case 1:
				printFleet(jets);
				break;
			case 2:
				fly(jets);
				break;
			case 3:
				fastestJet(jets);
				break;
			case 4:
				longestRange(jets);
				break;
			case 5:
				loadCargo(jets);
				break;
			case 6:
				dogFight(jets);
				break;
			case 7:
				addJet(jets);
				break;
			case 8:
				removeJet(jets);
				break;
		}
		} while(choice!= 9);
		
		
		
		
	}

	public void menu() {
		System.out.println("1: List fleet");
		System.out.println("2: Fly all jets");
		System.out.println("3: View fastest jet");
		System.out.println("4: View jet with longest range");
		System.out.println("5: Load all Cargo Jets");
		System.out.println("6: Dogfight!");
		System.out.println("7: Add a jet to Fleet");
		System.out.println("8: Remove a jet from Fleet");
		System.out.println("9: Quit");

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
		System.out.println();
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

		System.out.println("Fastest Jet: " + fastestJet.toString());
		System.out.println();
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
		System.out.println("longest range " + longestRangeJet.toString());
		System.out.println();
	}

	public void loadCargo(List<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
		System.out.println();
	}

	public void dogFight(List<Jet> jetList) {
		for (Jet jet : jetList) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
		System.out.println();
	}
	
	public void addJet(List<Jet> jetList) {
		int model;
		double speed;
		int range;
		long price;
		Jet newJet = null;
		System.out.println("Add new Jet.\n 1: Fighter\n 2: Cargo\n 3: lmpl");
		model = kb.nextInt();
		
		System.out.println("Add the speed of the jet (ex 122.45):");
		speed = kb.nextDouble();
		kb.nextLine();
		
		System.out.println("Add the range of the jet (ex 1000)");
		range = kb.nextInt();
		kb.nextLine();
		
		System.out.println("Add price of jet (ex 2990177)");
		price = kb.nextLong();
		
		if(model == 1) {
			newJet = new FighterJet("fighter", speed, range, price);
		}
		else if (model == 2) {
			newJet = new CargoPlane("CargoPlane", speed, range, price);
		}
		else if (model == 3) {
			newJet = new Jetlmpl("Jetlmpl", speed, range, price);
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
