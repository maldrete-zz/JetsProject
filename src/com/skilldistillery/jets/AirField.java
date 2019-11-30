package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	public List<Jet> jets;

	public AirField() {
		jets = new ArrayList<>();

	}

	public List<Jet> parseFile() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("jets.txt"));
			String line = "";
			// id, name color breed age gender comments
			while ((line = br.readLine()) != null) {
				String[] jetInfo = line.split(", ");
				Jet newJet = null;
				// String model, double speed, int range, long price
				if (jetInfo[0].equals("Fighter")) {
					newJet = new FighterJet(jetInfo[0], Double.parseDouble(jetInfo[1]), Integer.parseInt(jetInfo[2]),
							Long.parseLong(jetInfo[3]));
					jets.add(newJet);
				}
				if (jetInfo[0].equals("CargoPlane")) {
					newJet = new FighterJet(jetInfo[0], Double.parseDouble(jetInfo[1]), Integer.parseInt(jetInfo[2]),
							Long.parseLong(jetInfo[3]));
					jets.add(newJet);
				}
				if (jetInfo[0].equals("Jetlmpl")) {
					newJet = new FighterJet(jetInfo[0], Double.parseDouble(jetInfo[1]), Integer.parseInt(jetInfo[2]),
							Long.parseLong(jetInfo[3]));
					jets.add(newJet);
				}

			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return jets;

	}

}
