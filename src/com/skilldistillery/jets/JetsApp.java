package com.skilldistillery.jets;

import java.util.List;

public class JetsApp {
	private static AirField af = new AirField();

	public static void main(String[] args) {
		JetsApp app = new JetsApp();
//		 app.printFleet(af.parseFile());
//		 app.fly(af.parseFile());
//		app.fastestJet(af.parseFile());
//		app.longestRange(af.parseFile());
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
	}}
