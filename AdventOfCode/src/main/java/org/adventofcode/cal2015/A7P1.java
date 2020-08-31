package org.adventofcode.cal2015;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import org.adventofcode.logiccircuit.*;
import org.adventofcode.math.Vec2;
import org.adventofcode.templates.Assignment;
import org.adventofcode.templates.CalenderAssignment;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@CalenderAssignment(calendarName = "2015", assignmentName = "Circuit board", number = 13, description = "Get list of logic gate configurations (NOT, AND, OR, LSHIFT, RSHIFT, set value on wire)\nWhat is the value on the wire 'a' in the circuit?")
public class A7P1 extends Assignment {

    @FXML
    private TextArea input;
    @FXML
    private TextArea output;

    public A7P1(String name) {
        super(name);
    }

    @Override
    public Node getContent() throws IOException {
        return loadDefaultContent(this);
    }

    @FXML
    public void run(ActionEvent event) throws NoSuchAlgorithmException {

        String[] lines = input.getText().split("\n");
        LogicCircuit circuit = new LogicCircuit();

        for (String line : lines) {
            String[] tokens = line.split(" ");

            if (tokens.length == 3) {
                try {
                    circuit.addGate(new NumberGate(Integer.parseInt(tokens[0]), tokens[2]));
                }
                catch (NumberFormatException ex) {
                    circuit.addGate(new NumberGate(tokens[0], tokens[2]));
                }


            }
            else if (tokens.length == 4) {
                circuit.addGate(new NotGate(tokens[1], tokens[3]));
            }
            else if (tokens.length == 5) {
                if (tokens[1].equals("AND")) {
                    try {
                        int input1 = Integer.parseInt(tokens[0]);
                        String id = UUID.randomUUID().toString();
                        circuit.addGate(new NumberGate(input1, id));
                        circuit.addGate(new AndGate(id, tokens[2], tokens[4]));
                    }
                    catch (NumberFormatException ex) {
                        circuit.addGate(new AndGate(tokens[0], tokens[2], tokens[4]));
                    }
                }
                else if (tokens[1].equals("OR")) {
                    circuit.addGate(new OrGate(tokens[0], tokens[2], tokens[4]));
                }
                else if (tokens[1].equals("LSHIFT")) {
                    String id = UUID.randomUUID().toString();
                    circuit.addGate(new NumberGate(Integer.parseInt(tokens[2]), id));
                    circuit.addGate(new LShiftGate(tokens[0], id, tokens[4]));
                }
                else if (tokens[1].equals("RSHIFT")) {
                    String id = UUID.randomUUID().toString();
                    circuit.addGate(new NumberGate(Integer.parseInt(tokens[2]), id));
                    circuit.addGate(new RShiftGate(tokens[0], id, tokens[4]));
                }
            }

        }

        circuit.run();

        output.setText("The output of wire 'a' after the " + lines.length + " instructions is: " + circuit.getValueOfOutput("a"));
    }




}
