package dk.magnusjensen.adventofcode.cal2015;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import dk.magnusjensen.adventofcode.maths.Vec2;
import dk.magnusjensen.adventofcode.templates.Assignment;
import dk.magnusjensen.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = 2015, assignmentName = "Lights 1000 x 1000", number = 11, description = "Placeholder.")
public class A6P1 extends Assignment {
	
	@FXML
	private TextArea output;

	public A6P1(String name) {
		super(name);
	}

	

	@FXML
	public void partOne(String input) {
		String[] commands = input.split("\n");

		ArrayList<Light> lights = new ArrayList<>();

		for (int i = 0; i < 1000; i++) {
			for (int k = 0; k < 1000; k++) {
				lights.add(new Light(i, k));
			}
		}

		for (String command : commands) {
			String[] parts = command.split(" ");

			if (parts[0].equals("toggle")) {
				String firstCords = parts[1];
				String lastCords = parts[3];
				int firstX = Integer.parseInt(firstCords.split(",")[0]);
				int firstY = Integer.parseInt(firstCords.split(",")[1]);
				int lastX = Integer.parseInt(lastCords.split(",")[0]);
				int lastY = Integer.parseInt(lastCords.split(",")[1]);

				lights.forEach((light) -> {
					if ( (light.getX() <= lastX && light.getX() >= firstX) && (light.getY() <= lastY && light.getY() >= firstY)) {
						light.toggleLight();
					}
				});
			} else {
				String firstCords = parts[2];
				String lastCords = parts[4];
				int firstX = Integer.parseInt(firstCords.split(",")[0]);
				int firstY = Integer.parseInt(firstCords.split(",")[1]);
				int lastX = Integer.parseInt(lastCords.split(",")[0]);
				int lastY = Integer.parseInt(lastCords.split(",")[1]);
				lights.forEach((light) -> {
					if ( (light.getX() <= lastX && light.getX() >= firstX) && (light.getY() <= lastY && light.getY() >= firstY)) {
						light.setTurnedOn(parts[1].equals("on"));
					}
				});

			}
		}
		int counter = 0;
		for (Light light : lights) {
			if (light.isTurnedOn()) {
				counter++;
			}
		}

		output.setText("Total lights turned on: " + counter);
	}

	private class Light extends Vec2 {

		public boolean turnedOn;

		public Light(int x, int y) {
			super(x, y);
			this.turnedOn = false;
		}

		public boolean isTurnedOn() {
			return turnedOn;
		}

		public void setTurnedOn(boolean turnedOn) {
			this.turnedOn = turnedOn;
		}

		public void toggleLight() {
			this.turnedOn = !this.turnedOn;
		}
	}
}
