package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Light;
import org.adventofcode.maths.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.util.ArrayList;

@CalenderAssignment(calendarName = "2015", assignmentName = "Light Level 1000 x 1000", number = 12, description = "Placeholder.")
public class A6P2 extends Assignment {
	@FXML
	private TextArea input;
	@FXML
	private TextArea output;

	public A6P2(String name) {
		super(name);
	}

	@Override
	public Node getContent() throws IOException {
		Node content = loadDefaultContent(this);
		setInputContent(input, 2015, 6);
		return content;
	}

	@FXML
	public void run(ActionEvent event) {
		String[] commands = input.getText().split("\n");

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
			counter += light.lightLevel;
		}

		output.setText("Total Light level is: " + counter);
	}

	private class Light extends Vec2 {

		public boolean turnedOn;

		private int lightLevel;

		public Light(int x, int y) {
			super(x, y);
			this.turnedOn = false;
			this.lightLevel = 0;
		}

		public boolean isTurnedOn() {
			return turnedOn;
		}

		public void setTurnedOn(boolean turnedOn) {
			this.turnedOn = turnedOn;
			if (turnedOn) {
				setLightLevel(1);
			} else {
				setLightLevel(-1);
			}
		}

		public void setLightLevel(int amount) {
			if (this.lightLevel + amount < 0) {
				return;
			}
			this.lightLevel += amount;
		}

		public void toggleLight() {
			this.turnedOn = !this.turnedOn;
			this.setLightLevel(2);
		}
	}
}
